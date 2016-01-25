package br.unb.dali.models.agg.uml.sd.messages;

import agg.attribute.AttrInstance;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.uml.SequenceDiagram;
import br.unb.dali.models.agg.uml.sd.occurrences.Event;

/**
 * This class represents a message sent between two lifelines events in an UML Sequence Diagram context.
 * 
 * @author abiliooliveira
 */
public class AsyncMessage extends AbstractAggNode {
	private Event _send;
	private Event _receive;
	private String _signal;

	/********************************* CONSTRUCTORS *************************************/ 
	 
	/**
	 * Constrcuts an empty new Sequece Diagram.
	 *  
	 * @param id a string identifier fo this object
	 * @param context the context model
	 */
	public AsyncMessage(String id, SequenceDiagram context) {
		super(id, null, context);
	}
	
	/**
	 * Constructs a new Sequence Diagram Message Object via underlying AGG Node structure
	 * 
	 * @param aggNode the agg graph node that this object will be constructed from
	 * @param send the send event related to this message
	 * @param receive the receive event related to this message
	 * @param context the context model
	 * @throws NullAggContextException
	 */
//	public Message(Node aggNode, Event send, Event receive, AbstractAggModel context) throws NullAggContextException {
//		super(Misc.getRandomString(), aggNode, context);
//		this._send = send;
//		this._receive = receive;
//	}

	/********************************* INHERITANCE **************************************/
	@Override
	protected void setUp() {
		AttrInstance attrs = _aggNode.getAttribute();
		Object value = attrs.getValueAt("signal");
		if (value != null)
			_signal = (String)value;
		
	}
	
	/********************************* PUBLIC BEHAVIOR **************************************/
	
	/**
	 * Sets the send and receive events of this message
	 * 
	 * @param send the lifeline event that is sending this message
	 * @param receive the lifeline event that is receiving this message 
	 * @return this
	 */
	public AsyncMessage setSendAndReceive(Event send, Event receive) {
		this._send = send;
		this._receive = receive;
		send.setMessage(this);
		receive.setMessage(this);
		return this;
	}
	
	/**
	 * @return the send lifeline event
	 */
	public Event getSend() {
		return _send;
	}
	
	/**
	 * @return the receive event
	 */
	public Event getReceive() {
		return _receive;
	}
	
	/**
	 * @return this message's signal
	 */
	public String getSignal() {
		return _signal;
	}

}
