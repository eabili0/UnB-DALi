package br.unb.dali.models.agg.uml.sd.relations;

import br.unb.dali.models.agg.AbstractAggEdge;
import br.unb.dali.models.agg.exceptions.AggEdgeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.SequenceDiagram;
import br.unb.dali.models.agg.uml.sd.Occurrence;

class Next extends AbstractAggEdge {

	public Next(String id, Occurrence source, Occurrence target, SequenceDiagram context) 
			throws NullAggContextException, AggEdgeConstructionException {
		super(id, source, target, context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub
		
	}

}
