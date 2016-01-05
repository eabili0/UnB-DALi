package br.unb.dali.models.agg.uml.ad.edges;

import agg.xt_basis.Arc;
import br.unb.dali.models.agg.exceptions.InconsistentEdgeTypeException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.exceptions.NullArcException;
import br.unb.dali.models.agg.exceptions.NullSourceOfAggEdgeException;
import br.unb.dali.models.agg.exceptions.NullTargetOfAggEdgeException;
import br.unb.dali.models.agg.uml.Activity;
import br.unb.dali.models.agg.uml.ad.ActivityEdge;
import br.unb.dali.models.agg.uml.ad.ActivityNode;

public class ControlFlow extends ActivityEdge {

	/**
	 * Constructs a control flow edge based on an agg arc 
	 * @param arc
	 * @param context
	 * @throws NullTargetOfAggEdgeException 
	 * @throws NullSourceOfAggEdgeException 
	 * @throws NullArcException 
	 * @throws InconsistentEdgeTypeException 
	 * @throws NullAggContextException 
	 */
	public ControlFlow(Arc arc, Activity context) throws NullSourceOfAggEdgeException, NullTargetOfAggEdgeException, NullArcException, InconsistentEdgeTypeException, NullAggContextException {
		super(arc, context);
	}
	
	/**
	 * Constructs a new control flow object
	 * @param source
	 * @param target
	 * @throws NullTargetOfAggEdgeException 
	 * @throws NullSourceOfAggEdgeException 
	 * @throws NullAggContextException 
	 */
	public ControlFlow(ActivityNode source, ActivityNode target, Activity context) throws NullSourceOfAggEdgeException, NullTargetOfAggEdgeException, NullAggContextException {
		super(source, target, context);
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub
		
	}

}
