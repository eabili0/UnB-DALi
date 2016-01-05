package br.unb.dali.models.agg.markovchains.dtmc;

import agg.xt_basis.Arc;
import br.unb.dali.models.agg.AbstractAggEdge;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.exceptions.InconsistentEdgeTypeException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.exceptions.NullArcException;
import br.unb.dali.models.agg.exceptions.NullSourceOfAggEdgeException;
import br.unb.dali.models.agg.exceptions.NullTargetOfAggEdgeException;

public abstract class DTMCTransition extends AbstractAggEdge {

	public DTMCTransition(Arc arc, AbstractAggModel context)
			throws NullArcException, NullSourceOfAggEdgeException,
			NullTargetOfAggEdgeException, InconsistentEdgeTypeException,
			NullAggContextException {
		super(arc, context);
		// TODO Auto-generated constructor stub
	}

	public DTMCTransition(AbstractAggNode source, AbstractAggNode target,
			AbstractAggModel context) throws NullSourceOfAggEdgeException,
			NullTargetOfAggEdgeException, NullAggContextException {
		super(source, target, context);
		// TODO Auto-generated constructor stub
	}

}
