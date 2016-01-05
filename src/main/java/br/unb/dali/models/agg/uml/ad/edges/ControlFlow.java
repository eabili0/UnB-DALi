package br.unb.dali.models.agg.uml.ad.edges;

import agg.xt_basis.Arc;
import br.unb.dali.models.agg.exceptions.AggEdgeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.Activity;
import br.unb.dali.models.agg.uml.ad.ActivityEdge;
import br.unb.dali.models.agg.uml.ad.ActivityNode;

public class ControlFlow extends ActivityEdge {

	/**
	 * Constructs a control flow edge based on an agg arc 
	 * @param arc
	 * @param context
	 * @throws NullAggContextException 
	 * @throws AggEdgeConstructionException 
	 */
	public ControlFlow(Arc arc, Activity context) throws NullAggContextException, AggEdgeConstructionException {
		super(arc, context);
	}
	
	/**
	 * Constructs a new control flow object
	 * @param source
	 * @param target
	 * @throws NullAggContextException 
	 * @throws AggEdgeConstructionException 
	 */
	public ControlFlow(ActivityNode source, ActivityNode target, Activity context) throws NullAggContextException, AggEdgeConstructionException {
		super(source, target, context);
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub
		
	}

}
