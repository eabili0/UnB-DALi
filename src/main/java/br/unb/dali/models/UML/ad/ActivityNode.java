package br.unb.dali.models.uml.ad;

import java.util.LinkedHashSet;

import br.unb.dali.models.uml.UMLTypeSetUtil;
import br.unb.dali.util.agg.IAggNode;
import agg.xt_basis.Node;
import agg.xt_basis.Type;

/**
 * This class defines what is an ActivityNode in the context of the Activity Diagram defined in this library;
 * We tried to keep faithful to the UML 2.5 standard
 * 
 * Property {@link #_aggNode} defines the underlying agg type of this uml activity diagram node
 * Property {@link #_type} defines the underlying agg node of this uml activity diagram node
 * Property {@link #incoming} defines the set of outgoing edges from this node  
 * Property {@link #outgoing} defines the set of incoming edges to this node
 * 
 * @author abiliooliveira
 */
public abstract class ActivityNode implements IAggNode {
	protected Type _type; 
	protected Node _aggNode;  
	protected LinkedHashSet<ActivityEdge> outgoing;
	protected LinkedHashSet<ActivityEdge> incoming;
	
	/**
	 * This model sets up the node structures based on the property _aggNode
	 * 
	 * Every ActivityNode subclass MUST implement this method, since it is always called by any constructor
	 */
	protected abstract void setUp();
	
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
	
	/**
	 * All nodes have to provide a way to initialize them by an agg node;
	 * If a subclass wants to provide an empty constructor, one only have to pass a null aggNode to this constructor
	 * 
	 * @param aggNode
	 */
	public ActivityNode(Node aggNode) {
		setType();
		_aggNode = (aggNode!=null)?aggNode:new Node(null, _type, null);
		setUp();
	}
	
	/**
	 * sets up the agg type of this node
	 */
	private void setType() {
		this._type = UMLTypeSetUtil.ADTypeSet.getTypeByName(getClass().getSimpleName());
	}
}
