package br.unb.dali.models.agg.uml.sd;

import agg.attribute.AttrInstance;
import agg.xt_basis.Node;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.exceptions.AggEdgeConstructionException;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.SequenceDiagram;
import br.unb.dali.models.agg.uml.sd.occurrences.Event;
import br.unb.dali.models.agg.uml.sd.relations.Send;
import br.unb.dali.util.io.Misc;

public class Message extends AbstractAggNode {
	private Event _send;
	private Event _receive;
	private String _signal;

	/********************************* CONSTRUCTORS *************************************/ 
	 
	/**
	 * @throws AggNodeConstructionException 
	 * @throws NullAggContextException 
	 */
	public Message(String id, SequenceDiagram context) throws NullAggContextException, AggNodeConstructionException {
		super(id, null, context);
	}
	
	/**
	 * Constructs a new Sequence Diagram Message Object via underlying AGG Node structure
	 * 
	 * @param aggNode
	 * @param send
	 * @param receive
	 * @param context
	 * @throws NullAggContextException
	 * @throws AggNodeConstructionException
	 */
	public Message(Node aggNode, Event send, Event receive, AbstractAggModel context)
			throws NullAggContextException, AggNodeConstructionException {
		super(Misc.getRandomString(), aggNode, context);
		this._send = send;
		this._receive = receive;
	}

	/********************************* INHERITANCE **************************************/
	@Override
	protected void setUp() {
		AttrInstance attrs = _aggNode.getAttribute();
		Object value = attrs.getValueAt("signal");
		if (value != null)
			_signal = (String)value;
		
	}
	
	/********************************* PUBLIC BEHAVIOR **************************************/
	public Event getSend() {
		return _send;
	}
	
	public Event getReceive() {
		return _receive;
	}
	
	public String getSignal() {
		return _signal;
	}
	
	public Message setSendAndReceive(Event send, Event receive) throws NullAggContextException, AggEdgeConstructionException {
		this._context.addAnAggNode(send);
		this._context.addAnAggNode(receive);
		this._context.addAnAggEdge(new Send(this, send, (SequenceDiagram)this._context));
		setSend(send);setReceive(receive);
		return this;
	}
	
	public Message setSend(Event e) {
		this._send = e;
		return this;
	}
	
	public Message setReceive(Event e) {
		this._receive = e;
		return this;
	}

}
