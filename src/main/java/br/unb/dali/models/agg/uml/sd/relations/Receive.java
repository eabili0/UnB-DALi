package br.unb.dali.models.agg.uml.sd.relations;

import br.unb.dali.models.agg.AbstractAggEdge;
import br.unb.dali.models.agg.uml.SequenceDiagram;
import br.unb.dali.models.agg.uml.sd.messages.AsyncMessage;
import br.unb.dali.models.agg.uml.sd.occurrences.Event;
import br.unb.dali.util.io.IOHelper;

/**
 * Instancies of this class represents an Agg relation (arc) betwwen an SD Lifeline Event and an AsynMessage
 * @author abiliooliveira
 */
public class Receive extends AbstractAggEdge {

	/**
	 * Constructs a Receive relation between an Event and an AsyncMessage
	 * @param source the asyncmessage object
	 * @param target the event object
	 * @param context the context model
	 */
	public Receive(AsyncMessage source, Event target, SequenceDiagram context) {
		super(IOHelper.getRandomString(), source, target, context);
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub
	}

}
