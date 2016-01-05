package br.unb.dali.models.agg.uml.ad;

import agg.xt_basis.Arc;
import br.unb.dali.models.agg.AbstractAggEdge;
import br.unb.dali.models.agg.exceptions.InconsistentEdgeTypeException;
import br.unb.dali.models.agg.exceptions.NullArcException;
import br.unb.dali.models.agg.exceptions.NullSourceOfAggEdgeException;
import br.unb.dali.models.agg.exceptions.NullTargetOfAggEdgeException;
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
	 * @param arc MUST NOT be NULL
	 * @throws NullArcException 
	 * @throws NullTargetOfAggEdgeException 
	 * @throws NullSourceOfAggEdgeException 
	 * @throws InconsistentEdgeTypeException 
	 */
	public ActivityEdge(Arc arc, Activity context) throws NullArcException, NullSourceOfAggEdgeException, NullTargetOfAggEdgeException, InconsistentEdgeTypeException {
		super(arc, context);
	}
	
	/**
	 * Constructs a new ActivityEdge, forcing the call to setType
	 * $source and $target MUST NOT be null
	 * 
	 * @param source must not be null
	 * @param target must not be null
	 * @throws NullTargetOfAggEdgeException 
	 * @throws NullSourceOfAggEdgeException 
	 */
	public ActivityEdge(ActivityNode source, ActivityNode target, Activity context) throws NullSourceOfAggEdgeException, NullTargetOfAggEdgeException  {
		super(source, target, context);
		
	}
}
