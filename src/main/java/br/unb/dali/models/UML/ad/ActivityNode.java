package br.unb.dali.models.uml.ad;

import java.util.LinkedHashSet;

import br.unb.dali.models.uml.UMLTypeSetUtil;
import br.unb.dali.util.agg.IAggNode;
import agg.xt_basis.Node;
import agg.xt_basis.Type;

public abstract class ActivityNode implements IAggNode {
	protected Type _type; // the agg type of this uml activity diagram node
	protected Node _aggNode; // the agg node of this uml activity diagram node
	
	protected LinkedHashSet<ActivityEdge> outgoing; // a linked hash set of the outgoing edges of this node
	protected LinkedHashSet<ActivityEdge> incoming; // a linked hash set of the outgoing edges of this node
	
	/**
	 * Initializes the uml activity diagram node, forcing the call to {@link #setType()}
	 */
	public ActivityNode() {
		setType();
	}
	
	public ActivityNode(Node aggNode) {
		setType();
		if (aggNode.getType().getName().equals(_type.getName())) {
			
		}
	}
	
	/**
	 * sets up the agg type of this node
	 */
	protected void setType() {
		this._type = UMLTypeSetUtil.ADTypeSet.getTypeByName(getClass().getSimpleName());
	}
	
	/**
	 * adds an outgoing edge from this node
	 * @param edge
	 */
	public void addOutgoingEdge(ActivityEdge edge) {
		outgoing.add(edge);
	}
	
	/**
	 * adds an ingoing edge to this node
	 * @param edge
	 */
	public void addIngoingEdge(ActivityEdge edge) {
		incoming.add(edge);
	}
	
	/**
	 * @return the underlying agg type of this node
	 */
	public Type getAggType() {
		return this._type;
	}
	
	/**
	 * @return the underlying agg node representation of this UML AD node
	 */
	public Node getAggNode() {
		return this._aggNode;
	}
}
