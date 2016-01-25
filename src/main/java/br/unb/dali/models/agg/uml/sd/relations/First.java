package br.unb.dali.models.agg.uml.sd.relations;

import br.unb.dali.models.agg.AbstractAggEdge;
import br.unb.dali.models.agg.uml.SequenceDiagram;
import br.unb.dali.models.agg.uml.sd.Lifeline;
import br.unb.dali.models.agg.uml.sd.Occurrence;
import br.unb.dali.util.io.IOHelper;

public class First extends AbstractAggEdge {

	public First(Lifeline source, Occurrence target, SequenceDiagram context) {
		super(IOHelper.getRandomString(), source, target, context);
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub
		
	}

}
