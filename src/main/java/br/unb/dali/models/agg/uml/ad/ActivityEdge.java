package br.unb.dali.models.agg.uml.ad;

import agg.xt_basis.Arc;
import br.unb.dali.models.agg.AbstractAggEdge;
import br.unb.dali.models.agg.exceptions.AggEdgeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.Activity;

/**
 * This class defines what is an ActivityEdge in the context of the Activity Diagram defined in this library;
 * We tried to keep faithful to the UML 2.5 standard.
 * 
 * Property {@link #_arc} defines the underlying agg arc of this uml activity diagram edge
 * Property {@link #_type} defines the underlying agg type of this uml activity diagram edge
 * Property {@link #source} defines the node where this activity edge is generated from  
 * Property {@link #target} defines the node where this activity is pointing to
 * 
 * @author abiliooliveira
 */
public abstract class ActivityEdge extends AbstractAggEdge {
	
	/**
	 * Constructs a new ActivityEdge based on an agg arc
	 * 
	 * @param id this activity edge identifier (MUST NOT be NULL or EMPTY)
	 * @param arc MUST NOT be NULL
	 * @param context MUST NOT be NULL
	 * 
	 * @throws AggEdgeConstructionException 
	 * @throws NullAggContextException 
	 */
	public ActivityEdge(String id, Arc arc, Activity context) throws AggEdgeConstructionException, NullAggContextException {
		super(id, arc, context);
	}
	
	/**
	 * Constructs a new ActivityEdge, forcing the call to setType
	 * 
	 * @param id this activity edge identifier (MUST NOT be NULL or EMPTY)
	 * @param source MUST NOT be NULL
	 * @param target MUST NOT be NULL
	 * 
	 * @throws AggEdgeConstructionException
	 * @throws NullAggContextException 
	 */
	public ActivityEdge(String id, ActivityNode source, ActivityNode target, Activity context) throws AggEdgeConstructionException, NullAggContextException  {
		super(id, source, target, context);		
	}
}
