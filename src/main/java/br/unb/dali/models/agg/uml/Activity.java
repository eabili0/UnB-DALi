package br.unb.dali.models.agg.uml;

import java.util.HashMap;
import java.util.Map;

import agg.attribute.AttrInstance;
import agg.attribute.impl.AttrTupleManager;
import agg.xt_basis.Arc;
import agg.xt_basis.Graph;
import agg.xt_basis.Node;
import agg.xt_basis.Type;
import br.unb.dali.models.agg.AnAggModel;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.models.agg.uml.ad.ActivityEdge;
import br.unb.dali.models.agg.uml.ad.ActivityNode;
import br.unb.dali.models.agg.uml.ad.edges.ControlFlow;
import br.unb.dali.models.agg.uml.ad.nodes.control.DecisionNode;
import br.unb.dali.models.agg.uml.ad.nodes.control.FinalNode;
import br.unb.dali.models.agg.uml.ad.nodes.control.InitialNode;
import br.unb.dali.models.agg.uml.ad.nodes.control.MergeNode;
import br.unb.dali.models.agg.uml.ad.nodes.executable.ExecutableNode;

/**
 * This class defines a subset of an 2.5 standard Activity Diagram
 * It extends AModel, so it can be used in transformations that extends ATransformation
 * We tried to keep faithful to the UML 2.5 standard.
 * 
 * Property {@link #edges} defines the activity edges as a map of AGG Arcs to ActivityEdges
 * Property {@link #nodes} defines the activity nodes as a map of AGG Nodes to ActivityNodes
 * 
 * @author abiliooliveira
 */
public class Activity extends AnAggModel{
	private static final String gragra = "models/AD.ggx";
	private Map<Node, ActivityNode> nodes;
	private Map<Arc, ActivityEdge> edges;
	
	/*********************** CONSTRUCTORS ***********************/
	
	/** 
	 * Initializes a new UML Activity Diagram
	 * @throws ModelSemanticsVerificationException
	 */
	public Activity() throws ModelSemanticsVerificationException {
		super(null);
	}
	
	/**
	 * Constructs a new UML Activity Diagram based on an AGG graph
	 * @param graph
	 * @throws ModelSemanticsVerificationException
	 */
	public Activity(Graph graph) throws ModelSemanticsVerificationException {
		super(graph);
	}
	
	/*********************** INHERITANCE ***********************/

	@Override
	protected String getGraGraResourceFileName() {
		return gragra;
	}
	
	@Override
	public boolean checkModel() throws ModelSemanticsVerificationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void setUp() {
		// init our repositories of nodes and edges
		this.nodes = new HashMap<Node, ActivityNode>();
		this.edges = new HashMap<Arc, ActivityEdge>();
		
		// TODO Auto-generated method stub
		
	}
	
	/*********************** PUBLIC ***********************/
	
	/**
	 * Adds a new ControlFlow edge to this UML Activity Diagram 
	 * @param edge
	 */
	public void addControlFlow(ControlFlow edge) {
		addAnADEdge(edge);
	}
	
	/**
	 * Adds a new DecisionNode node to this UML Activity Diagram
	 * @param node
	 */
	public void addDecisionNode(DecisionNode node) {
		addAnADNode(node);
	}
	
	/**
	 * Adds a new FinalNode node to this UML Activity Diagram 
	 * @param node
	 */
	public void addFinalNode(FinalNode node) {
		addAnADNode(node);
	}
	
	/**
	 * Adds a new Initialnode node to this UML Activity Diagram
	 * @param node
	 */
	public void addInitialNode(InitialNode node) {
		addAnADNode(node);
	}
	
	/**
	 * Adds a new MergeNode node to this UML Activity Diagram
	 * @param node
	 */
	public void addMergeNode(MergeNode node) {
		addAnADNode(node);
	}
	
	/**
	 * Adds a new ExecutableNode node to this UML Activity Diagram
	 * @param node
	 */
	public void addExecutableNode(ExecutableNode node) {
		addAnADNode(node);
	}
	
	/**
	 * Searches for an activity node based on an agg node
	 * @param n
	 * @return the agg node n correspondent activity node
	 */
	public ActivityNode searchNode(Node n) {
		return this.nodes.getOrDefault(n, null);
	}
	
	/*********************** PRIVATE ***********************/
	
	/**
	 * adds a new activity diagram node to the model;
	 * privately configures the underlying AGG graph to hold the information of such a node
	 * @param node
	 */
	private void addAnADNode(ActivityNode node) {
		_graph.addNode(node.getAggNode()); // adds it to the graph
		nodes.put(node.getAggNode(), node); // puts a new entry on our HashMap of nodes
	}
	
	/**
	 * adds a new activity diagram edge to the model;
	 * privately configures the underlying AGG graph to hold the information of such an edge
	 * @param edge
	 */
	private void addAnADEdge(ActivityEdge edge) {
		Type t = _gragra.getTypeSet().getTypeByName(edge.getClass().getSimpleName());
		AttrInstance tt = AttrTupleManager.getDefaultManager().newInstance(
				t.getAttrType(), null);
		
		Arc newAggArc = new Arc(tt, edge.getAggType(), edge.getAggSourceNode(), edge.getAggTargetNode(), _graph);
		_graph.addArc(newAggArc);
		edges.put(newAggArc, edge);
	}

}
