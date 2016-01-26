package br.unb.dali.models.agg.uml.sd.relations;

import br.unb.dali.models.agg.AbstractAggEdge;
import br.unb.dali.models.agg.uml.SequenceDiagram;
import br.unb.dali.models.agg.uml.sd.messages.AsyncMessage;
import br.unb.dali.models.agg.uml.sd.occurrences.Event;
import br.unb.dali.util.io.IOHelper;

public class Send extends AbstractAggEdge {

	public Send(AsyncMessage source, Event target, SequenceDiagram context) {
		super(IOHelper.getRandomString(), source, target, context);
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub
		
	}

}
