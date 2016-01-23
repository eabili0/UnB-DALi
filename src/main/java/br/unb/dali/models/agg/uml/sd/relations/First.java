package br.unb.dali.models.agg.uml.sd.relations;

import br.unb.dali.models.agg.AbstractAggEdge;
import br.unb.dali.models.agg.exceptions.AggEdgeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.SequenceDiagram;
import br.unb.dali.models.agg.uml.sd.Lifeline;
import br.unb.dali.models.agg.uml.sd.Occurrence;
import br.unb.dali.util.io.Misc;

public class First extends AbstractAggEdge {

	public First(Lifeline source, Occurrence target, SequenceDiagram context) 
			throws NullAggContextException,AggEdgeConstructionException {
		super(Misc.getRandomString(), source, target, context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub
		
	}

}
