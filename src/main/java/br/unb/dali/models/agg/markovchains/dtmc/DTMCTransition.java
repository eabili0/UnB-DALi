package br.unb.dali.models.agg.markovchains.dtmc;

import agg.xt_basis.Arc;
import br.unb.dali.models.agg.AbstractAggEdge;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.exceptions.AggEdgeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;

public abstract class DTMCTransition extends AbstractAggEdge {

	public DTMCTransition(String id, Arc arc, AbstractAggModel context)
			throws NullAggContextException, AggEdgeConstructionException {
		super(id, arc, context);
		// TODO Auto-generated constructor stub
	}

	public DTMCTransition(String id, AbstractAggNode source, AbstractAggNode target,
			AbstractAggModel context) throws NullAggContextException, AggEdgeConstructionException {
		super(id, source, target, context);
		// TODO Auto-generated constructor stub
	}

}
