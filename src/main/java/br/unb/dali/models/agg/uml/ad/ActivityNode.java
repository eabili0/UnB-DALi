package br.unb.dali.models.agg.uml.ad;

import java.util.LinkedHashSet;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.InconsistentNodeTypeException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.ActivityDiagram;

/**
 * This class defines what is an ActivityNode in the context of the Activity Diagram defined in this library;
 * We tried to keep faithful to the UML 2.5 standard
 *
 * Property {@link #incoming} defines the set of outgoing edges from this node  
 * Property {@link #outgoing} defines the set of incoming edges to this node
 * 
 * @author abiliooliveira
 */
public abstract class ActivityNode extends AbstractAggNode {  
	protected LinkedHashSet<ActivityEdge> outgoing;
	protected LinkedHashSet<ActivityEdge> incoming;
	protected String _label;
	
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
	 * Sets the label of this ActivityNode
	 * @param label
	 */
	public void setLabel(String label) {
		_label = label;
	}
	
	/**
	 * All nodes have to provide a way to initialize them by an agg node;
	 * If a subclass wants to provide an empty constructor, one only have to pass a null aggNode to this constructor
	 * For more information, check {@link #super()}
	 * 
	 * @param id this activity node id
	 * @param aggNode
	 * @throws InconsistentNodeTypeException 
	 * @throws AggNodeConstructionException 
	 */
	public ActivityNode(String id, Node aggNode, ActivityDiagram context) throws NullAggContextException, AggNodeConstructionException {
		super(id, aggNode, context);
		outgoing = new LinkedHashSet<ActivityEdge>();
		incoming = new LinkedHashSet<ActivityEdge>();
	}
	
}
