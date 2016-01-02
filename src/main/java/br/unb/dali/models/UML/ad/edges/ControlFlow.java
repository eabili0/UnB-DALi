package br.unb.dali.models.uml.ad.edges;

import agg.xt_basis.Arc;
import br.unb.dali.models.exceptions.NullabilityOfSourceAndTargetNodeException;
import br.unb.dali.models.uml.Activity;
import br.unb.dali.models.uml.ad.ActivityEdge;
import br.unb.dali.models.uml.ad.ActivityNode;

public class ControlFlow extends ActivityEdge {

	/**
	 * Constructs a control flow edge based on an agg arc 
	 * @param arc
	 * @param context
	 * @throws NullabilityOfSourceAndTargetNodeException
	 */
	public ControlFlow(Arc arc, Activity context) throws NullabilityOfSourceAndTargetNodeException {
		super(arc, context);
	}
	
	/**
	 * Constructs a new control flow object
	 * @param source
	 * @param target
	 * @throws NullabilityOfSourceAndTargetNodeException
	 */
	public ControlFlow(ActivityNode source, ActivityNode target) throws NullabilityOfSourceAndTargetNodeException {
		super(source, target);
	}

}
