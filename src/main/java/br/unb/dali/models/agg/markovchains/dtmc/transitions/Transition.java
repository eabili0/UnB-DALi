package br.unb.dali.models.agg.markovchains.dtmc.transitions;

import agg.xt_basis.Arc;
import br.unb.dali.models.agg.AbstractAggEdge;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.exceptions.InconsistentEdgeTypeException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.exceptions.NullArcException;
import br.unb.dali.models.agg.exceptions.NullSourceOfAggEdgeException;
import br.unb.dali.models.agg.exceptions.NullTargetOfAggEdgeException;
import br.unb.dali.models.agg.markovchains.DTMC;

public class Transition extends AbstractAggEdge {

	/**
	 * Constructs a Transtion 
	 * @param arc
	 * @param context
	 * @throws NullArcException
	 * @throws NullSourceOfAggEdgeException
	 * @throws NullTargetOfAggEdgeException
	 * @throws InconsistentEdgeTypeException
	 * @throws NullAggContextException
	 */
	public Transition(Arc arc, DTMC context) throws NullArcException, NullSourceOfAggEdgeException,
			NullTargetOfAggEdgeException, InconsistentEdgeTypeException, NullAggContextException {
		super(arc, context);
		// TODO Auto-generated constructor stub
	}

	public Transition(AbstractAggNode source, AbstractAggNode target, DTMC context) 
			throws NullSourceOfAggEdgeException, NullTargetOfAggEdgeException, NullAggContextException {
		super(source, target, context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub

	}

}
