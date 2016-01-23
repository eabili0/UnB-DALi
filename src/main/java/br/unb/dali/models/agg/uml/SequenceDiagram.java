package br.unb.dali.models.agg.uml;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import agg.xt_basis.Arc;
import agg.xt_basis.Graph;
import agg.xt_basis.Node;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.exceptions.AggEdgeConstructionException;
import br.unb.dali.models.agg.exceptions.AggModelConstructionException;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.sd.Lifeline;
import br.unb.dali.models.agg.uml.sd.Message;
import br.unb.dali.models.agg.uml.sd.Occurrence;
import br.unb.dali.models.agg.uml.sd.occurrences.Event;
import br.unb.dali.util.io.Misc;

/**
 * This class represents the UML Sequence Diagram Model for Dependability Analysis.
 * It's underlying infrastructure relies on the AGG Engine.
 * 
 * @author abiliooliveira
 */
public class SequenceDiagram extends AbstractAggModel {
	private static final String _grammar = "/models/SD.ggx";
	private List<Lifeline> _lifelines;
	
	/**
	 * Constructs a new empty Sequence Diagram.
	 * 
	 * @param id the identification string of this Model
	 * @throws AggModelConstructionException (impossible with this constructor)
	 */
	public SequenceDiagram(String id) throws AggModelConstructionException {
		super(id, null, _grammar);
		_lifelines = new ArrayList<Lifeline>();
	}
	
	/**
	 * Constructs a Sequence Diagram from an AGG Graph object
	 *  
	 * @param graph the AGG Graph object
	 * @throws AggModelConstructionException 
	 * 	1 - if any of the objects of this Graph is not compatible with the type graph of this Model;
	 * 	2 - if syntactical errors are found;
	 * 	3 - if mandatory attributes are missing
	 */
	public SequenceDiagram(Graph graph) throws AggModelConstructionException {
		super(Misc.getRandomString(), graph, _grammar);
		// TODO Auto-generated constructor stub
	}

	/**************************** INHERITANCE BEHAVIOR *******************************/
	
	/**
	 * Checks the integrity of this Model
	 */
	@Override
	public void checkModel() throws ModelSemanticsVerificationException {
		if (!_gragra.checkGraphConsistency(_graph)) {
			throw new ModelSemanticsVerificationException("The underlying AGG Graph is not consistent with the syntactical constraints of its Type Graph!");
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
		} catch (Exception e) {
			throw new AggModelConstructionException(e);
		}
	}
	
	/**************************** PUBLIC BEHAVIOR *******************************/
	
	public SequenceDiagram addLifeline(Lifeline l) {
		this._lifelines.add(l);
		this.addAnAggNode(l);
		return this;
	}
	
	/**
	 * 
	 * @param sourceLifeline
	 * @param targetLifeline
	 * @param signal
	 * @return
	 * @throws NullAggContextException
	 * @throws AggEdgeConstructionException
	 * @throws AggNodeConstructionException
	 */
	public SequenceDiagram addAsyncMessage(String sourceLifeline, String targetLifeline, String signal) throws NullAggContextException, AggEdgeConstructionException, AggNodeConstructionException {
		Lifeline source = (Lifeline) this._nodesByString.get(sourceLifeline);
		Lifeline target = (Lifeline) this._nodesByString.get(targetLifeline);
		
		Occurrence send = source.addOccurrence(new Event(this));
		Occurrence receive = target.addOccurrence(new Event(this));
		
		Message m = new Message(signal, this).setSendAndReceive((Event)send, (Event)receive);
		
		return this;
	}
	/**************************** PRIVATE BEHAVIOR *******************************/

	private boolean setNodesUp(HashSet<Node> nodesSet) {
		// TODO Auto-generated method stub
		return false;
	}

	private void setArcsUp(HashSet<Arc> arcsSet) {
		// TODO Auto-generated method stub
	}

	
}
