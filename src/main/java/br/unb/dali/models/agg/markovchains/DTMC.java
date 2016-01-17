package br.unb.dali.models.agg.markovchains;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import agg.xt_basis.Arc;
import agg.xt_basis.Graph;
import agg.xt_basis.Node;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.exceptions.AggEdgeConstructionException;
import br.unb.dali.models.agg.exceptions.AggModelConstructionException;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.InconsistentEdgeTypeException;
import br.unb.dali.models.agg.exceptions.InconsistentNodeTypeException;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.markovchains.dtmc.DTMCState;
import br.unb.dali.models.agg.markovchains.dtmc.states.ErrorState;
import br.unb.dali.models.agg.markovchains.dtmc.states.InitialState;
import br.unb.dali.models.agg.markovchains.dtmc.states.State;
import br.unb.dali.models.agg.markovchains.dtmc.transitions.Transition;
import br.unb.dali.models.prism.PRISMModel;
import br.unb.dali.models.prism.PRISMModelTypes;
import br.unb.dali.models.prism.PRISMModule;
import br.unb.dali.util.io.Misc;

public class DTMC extends AbstractAggModel {
	private String _name = "";
	private static final String _grammar = "/models/DTMC.ggx";
	private DTMCState _initialState;
	
	/************************* CONSTRUCTORS ****************************/
	
	/**
	 * Constructs a new clean DTMC model
	 * 
	 * @param id this model identifier
	 * 
	 * @throws AggModelConstructionException should never happen at this point
	 */
	public DTMC(String id) throws AggModelConstructionException {
		super(id, null);
	}
	
	/**
	 * Constructs a DTMC model from the info of an Agg Graph object
	 * 
	 * @param graph the agg graph that hold the information of this DTMC model
	 * 
	 * @throws AggModelConstructionException 
	 * 	whenever inconsistencies are found when constructing this DTMC from the agg graph
	 */
	public DTMC(String id, Graph graph) throws AggModelConstructionException {
		super(id, graph);
	}
	
	/************************* PUBLIC ****************************/
	
	/**
	 * @return this DTMC model name
	 */
	public String getName() {
		return _name;
	}
	
	/**
	 * Sets the name of this DTMC model
	 * 
	 * @param name
	 * @return this
	 */
	public DTMC setName(String name) {
		this._name = name;
		return this;
	}
	
	/**
	 * @return the initial state of this dtmc
	 */
	public DTMCState getInitialState() {
		return _initialState;
	}
	
	/**
	 * Converts this DTMC to a proper PRISM module
	 * 
	 * @return the PRISM representation of this DTMC
	 */
	public String toPRISM() {
		PRISMModule module = new PRISMModule(_name);
		PRISMModel model = new PRISMModel(_name, PRISMModelTypes.DTMC);
		
		// add the state variable
		String states = "s[0.." + this._nodes.size() + "] init " + _initialState.getIndex() + ";";
		module.addVariable(states);
		
		// for each node, add a proper prism command to all its outgoing edges
		Iterator<Entry<Node, AbstractAggNode>> it = _nodes.entrySet().iterator();
		while (it.hasNext()) {
			module.addCommand(getCommand((DTMCState)it.next().getValue()));
			model.addModule(module);
		}
		
		return model.toString();
	}
	
	/************************* INHERITANCE ****************************/
	
	@Override
	public void checkModel() throws ModelSemanticsVerificationException {
		if (!_gragra.checkGraphConsistency(_graph)) {
			throw new ModelSemanticsVerificationException("");
		}
	}
	
	@Override
	protected void setUp() throws AggModelConstructionException {
		try {
			// set the nodes up
			if (setNodesUp(_graph.getNodesSet())) {
				// set the arcs up
				setArcsUp(_graph.getArcsSet());
			}
		} catch (NullAggContextException | AggNodeConstructionException | AggEdgeConstructionException e) {
			throw new AggModelConstructionException(e);
		}
 	}

	@Override
	protected String getGraGraResourceFileName() {
		return _grammar;
	}

	/************************* PRIVATE ****************************/
	
	/**
	 * Sets up the states of this DTMC model from a hash set of agg nodes
	 * @param nodes the underlying agg graph nodes
	 * @return true if there were states to be set up and everything ran ok; false otherwise 
	 * @throws NullAggContextException It will never happen in this case
	 * @throws AggNodeConstructionException when something wrong happens while setting up nodes from a graphs
	 */
	private boolean setNodesUp(HashSet<Node> nodes) throws NullAggContextException, AggNodeConstructionException {
		if (nodes != null && !nodes.isEmpty()) {
			for (Node node : nodes) {
				switch (node.getType().getName()) {	
					case "State":
						addAnAggNode(new State(Misc.getRandomString(), node, this));
						break;
					case "InitialState":
						_initialState = new InitialState(Misc.getRandomString(), node, this);
						addAnAggNode(_initialState);
						break;
					case "ErrorState":
						addAnAggNode(new ErrorState(Misc.getRandomString(), node, this));
						break;
					default:
						throw new InconsistentNodeTypeException();
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Sets up the transitions of this DTMC model from a hash set of agg arcs; 
	 * It'll only be called when the nodes were set up ok
	 *  
	 * @param arcs the underlying agg graph arcs
	 * @return true if everything ran fine and when there were arcs to setup; false otherwise
	 * @throws NullAggContextException should never happen
	 * @throws AggEdgeConstructionException when something wrong happens while setting up an transition from an arc
	 */
	private boolean setArcsUp(HashSet<Arc> arcs) throws NullAggContextException, AggEdgeConstructionException {
		if (arcs != null && !arcs.isEmpty()) {
			for (Arc arc : arcs) {
				switch (arc.getType().getName()) {
					case "Transition": 
						addAnAggEdge(new Transition(Misc.getRandomString(), arc, this));
						break;
					default:
						throw new InconsistentEdgeTypeException();
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * formats a proper DTMC command
	 * @param current
	 * @return
	 */
	private String getCommand(DTMCState current) {
		String toReturn = "";
		int size = current.getOutgoingEdges().size();
		
		// only create commands if the current node has at least one outgoing edge
		if (size > 0) { 
			toReturn = "[] s=" + current.getIndex() + " -> "; // guard
			
			for (int i = 0; i < size - 1; i++) {
				toReturn += getTransition((Transition)current.getOutgoingEdges().get(i), "+");
			}
			toReturn += getTransition((Transition)current.getOutgoingEdges().get(size-1), "");
		}
		return toReturn;
	}
	
	/**
	 * formats a DTMC prism transition from a Transition object
	 * @param transition
	 * @return
	 */
	private String getTransition(Transition transition, String append) {
		DTMCState target = (DTMCState)transition.getTargetNode();
		
		return  transition.getProbability() + ":" + "(s'=" +  target.getIndex() + ") " + append;
	}
}
