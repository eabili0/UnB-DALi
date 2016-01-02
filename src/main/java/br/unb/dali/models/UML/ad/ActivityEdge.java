package br.unb.dali.models.uml.ad;

import agg.xt_basis.Node;
import agg.xt_basis.Type;
import br.unb.dali.models.exceptions.NullabilityOfSourceAndTargetNodeException;
import br.unb.dali.models.uml.UMLTypeSetUtil;
import br.unb.dali.util.agg.IAggArc;

public abstract class ActivityEdge implements IAggArc {
	protected Type _type;
	public ActivityNode source;
	public ActivityNode target;
	
	/**
	 * constructs a new ADEdge, forcing the call to setType
	 * source and target MUST NOT be null
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
