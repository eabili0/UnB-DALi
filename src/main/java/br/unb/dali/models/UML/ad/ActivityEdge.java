package br.unb.dali.models.uml.ad;

import agg.xt_basis.Arc;
import agg.xt_basis.Node;
import agg.xt_basis.Type;
import br.unb.dali.models.exceptions.NullabilityOfSourceAndTargetNodeException;
import br.unb.dali.models.uml.Activity;
import br.unb.dali.models.uml.UMLTypeSetUtil;
import br.unb.dali.util.agg.IAggArc;

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
public abstract class ActivityEdge implements IAggArc {
	protected Type _type;
	protected Arc _arc;
	public ActivityNode source;
	public ActivityNode target;
	
	/**
	 * Constructs a new ActivityEdge based on an agg arc
	 * $arc MUST NOT be null
	 * 
	 * @param arc
	 * @throws NullabilityOfSourceAndTargetNodeException 
	 */
	public ActivityEdge(Arc arc, Activity context) throws NullabilityOfSourceAndTargetNodeException {
		this(context.searchNode((Node)arc.getSource()), context.searchNode((Node)arc.getTarget()));
		this._arc = arc;
	}
	
	/**
	 * Constructs a new ActivityEdge, forcing the call to setType
	 * $source and $target MUST NOT be null
	 * 
	 * @param source must not be null
	 * @param target must not be null
	 * @throws NullabilityOfSourceAndTargetNodeException 
	 */
	public ActivityEdge(ActivityNode source, ActivityNode target) throws NullabilityOfSourceAndTargetNodeException {
		setType();
		if (source != null && target != null) {
			this.source = source;
			this.target = target;
			this._arc = new Arc(null, _type, this.getAggSourceNode(), this.getAggTargetNode(), null);
		} else {
			throw new NullabilityOfSourceAndTargetNodeException();
		}
		
	}

	/**
	 * sets up the agg type of this edge
	 */
	protected void setType() {
		this._type = UMLTypeSetUtil.ADTypeSet.getTypeByName(getClass().getSimpleName());
	}
	
	/**
	 * @return the underlying agg type of this edge
	 */
	public Type getAggType() {
		return this._type;
	}
	
	/**
	 * alias to source.getAggNode()
	 * @return the underlying agg node of the UML AD source node
	 */
	public Node getAggSourceNode() {
		return this.source.getAggNode();
	}
	
	/**
	 * alias to target.getAggNode()
	 * @return the underlying agg node of the UML AD target node
	 */
	public Node getAggTargetNode() {
		return this.target.getAggNode();
	}
}
