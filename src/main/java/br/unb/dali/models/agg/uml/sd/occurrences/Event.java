package br.unb.dali.models.agg.uml.sd.occurrences;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.SequenceDiagram;
import br.unb.dali.models.agg.uml.sd.Message;
import br.unb.dali.models.agg.uml.sd.Occurrence;

public class Event extends Occurrence {
	private Message _message;
	
	public Event(SequenceDiagram context) throws NullAggContextException, AggNodeConstructionException {
		super(null, context);
	}
	
	public Event(Node aggNode, AbstractAggModel context)
			throws NullAggContextException, AggNodeConstructionException {
		super(aggNode, context);
	}
	
	/**
	 * @return the message of this event object
	 */
	public Message getMessage() {
		return _message;
	}
	
	/**
	 * Sets the message of this event
	 * @param m the message object to be set
	 * @return this
	 */
	public Event setMessage(Message m) {
		_message = m;
		return this;
	}

}
