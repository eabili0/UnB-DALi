package br.unb.dali.models.agg.markovchains;

import java.util.HashSet;

import agg.xt_basis.Arc;
import agg.xt_basis.Graph;
import agg.xt_basis.Node;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.exceptions.AggEdgeConstructionException;
import br.unb.dali.models.agg.exceptions.AggModelConstructionException;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.InconsistentEdgeTypeException;
import br.unb.dali.models.agg.exceptions.InconsistentNodeTypeException;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.exceptions.NullArcException;
import br.unb.dali.models.agg.exceptions.NullSourceOfAggEdgeException;
import br.unb.dali.models.agg.exceptions.NullTargetOfAggEdgeException;
import br.unb.dali.models.agg.markovchains.dtmc.states.FinalState;
import br.unb.dali.models.agg.markovchains.dtmc.states.InitialState;
import br.unb.dali.models.agg.markovchains.dtmc.states.State;
import br.unb.dali.models.agg.markovchains.dtmc.transitions.Transition;

public class DTMC extends AbstractAggModel {
	private static final String gragra = "/models/DTMC.ggx";
	
	/************************* CONSTRUCTORS ****************************/
	
	/**
	 * Constructs a new clean DTMC model
	 * @throws AggModelConstructionException should never happen at this point
	 */
	public DTMC() throws AggModelConstructionException {
		super(null);
	}
	
	/**
	 * Constructs a DTMC model from the indo of an Agg Graph object
	 * @param graph the agg graph that hold the information of this DTMC model
	 * @throws AggModelConstructionException 
	 * 	whenever inconsistencies are found when constructing this DTMC from the agg graph
	 */
	public DTMC(Graph graph) throws AggModelConstructionException {
		super(graph);
	}
	
	/************************* PUBLIC ****************************/
	public String toPRISM() {
		return "";
	}
	
	/************************* INHERITANCE ****************************/
	
	@Override
	public boolean checkModel() throws ModelSemanticsVerificationException {
		// TODO Auto-generated method stub
		return false;
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
		return gragra;
	}

	/************************* PRIVATE ****************************/
	
	/**
	 * Sets up the states of this DTMC model from a hash set of agg nodes
	 * @param nodes the underlying agg graph nodes
	 * @return true if there were states to be set up and everything ran ok; false otherwise 
	 * @throws NullAggContextException It will never happen in this case
	 * @throws InconsistentNodeTypeException If a node present in the graph has a type that is not expected
	 */
	private boolean setNodesUp(HashSet<Node> nodes) throws InconsistentNodeTypeException, NullAggContextException {
		if (nodes != null && !nodes.isEmpty()) {
			for (Node node : nodes) {
				switch (node.getType().getName()) {	
					case "State":
						addAnAggNode(new State(node, this));
						break;
					case "InitialState":
						addAnAggNode(new InitialState(node, this));
						break;
					case "FinalState":
						addAnAggNode(new FinalState(node, this));
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
	 * @throws InconsistentEdgeTypeException when an edge of unexpected type exists in the hash set $arcs
	 * @throws NullAggContextException should never happen
	 * @throws NullTargetOfAggEdgeException when the target of an agg edge is null
	 * @throws NullSourceOfAggEdgeException when the source of an agg edge is null
	 * @throws NullArcException when the arc is null; should never happen
	 */
	private boolean setArcsUp(HashSet<Arc> arcs) throws InconsistentEdgeTypeException, NullArcException, NullSourceOfAggEdgeException, NullTargetOfAggEdgeException, NullAggContextException {
		if (arcs != null && !arcs.isEmpty()) {
			for (Arc arc : arcs) {
				switch (arc.getType().getName()) {
					case "Transition": 
						addAnAggEdge(new Transition(arc, this));
						break;
					default:
						throw new InconsistentEdgeTypeException();
				}
			}
			return true;
		}
		return false;
	}
}
