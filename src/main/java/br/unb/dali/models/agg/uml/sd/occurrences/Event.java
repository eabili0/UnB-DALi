package br.unb.dali.models.agg.uml.sd.occurrences;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.SequenceDiagram;
import br.unb.dali.models.agg.uml.sd.Occurrence;
import br.unb.dali.models.agg.uml.sd.messages.AsyncMessage;

/**
 * Instancies of this Class represents Message Events in SD Lifelines;
 * Since every Event is an occurrence in a Lifeline, we have that Event extends Occurrence.
 * 
 * @author abiliooliveira
 */
public class Event extends Occurrence {
	private AsyncMessage _message;
	
	/**
	 * Constructs a new empty Event object
	 * 
	 * @param context this object model context
	 */
	public Event(SequenceDiagram context) throws NullAggContextException, AggNodeConstructionException {
		super(null, context);
	}

	/**
	 * Constructs an Event object based on the information from an AggNode
	 * 
	 * @param aggNode the underlying agg node
	 * @param context this object context model
	 */
	public Event(Node aggNode, AbstractAggModel context)
			throws NullAggContextException, AggNodeConstructionException {
		super(aggNode, context);
	}
	
	/**
	 * @return the message of this event object
	 */
	public AsyncMessage getMessage() {
		return _message;
	}
	
	/**
	 * Sets the message of this event
	 * @param m the message object to be set
	 * @return this
	 */
	public Event setMessage(AsyncMessage m) {
		_message = m;
		return this;
	}

}
