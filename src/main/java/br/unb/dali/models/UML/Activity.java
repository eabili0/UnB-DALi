package br.unb.dali.models.uml;

import java.util.HashMap;
import java.util.Map;

import agg.xt_basis.Arc;
import agg.xt_basis.Graph;
import agg.xt_basis.Node;
import br.unb.dali.models.AModel;
import br.unb.dali.models.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.models.uml.ad.ActivityEdge;
import br.unb.dali.models.uml.ad.ActivityNode;
import br.unb.dali.models.uml.ad.edges.ControlFlow;
import br.unb.dali.models.uml.ad.nodes.control.DecisionNode;
import br.unb.dali.models.uml.ad.nodes.control.FinalNode;
import br.unb.dali.models.uml.ad.nodes.control.InitialNode;
import br.unb.dali.models.uml.ad.nodes.control.MergeNode;
import br.unb.dali.models.uml.ad.nodes.executable.ExecutableNode;

public class Activity extends AModel{
	private Map<Node,ActivityNode> nodes;
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
	public boolean checkModel() throws ModelSemanticsVerificationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void setUp() {
		// init our repositories of nodes and edges
		this.nodes = new HashMap<Node, ActivityNode>();
		this.edges = new HashMap<Arc,ActivityEdge>();
		
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void defineTypeSet() {
		this._typeSet = UMLTypeSetUtil.ADTypeSet;
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
	
	/*********************** PRIVATE ***********************/
	
	/**
	 * adds a new activity diagram node to the model;
	 * privately configures the underlying AGG graph to hold the information of such a node
	 * @param node
	 */
	private void addAnADNode(ActivityNode node) {
		Node newAggNode = new Node(null, node.getAggType(), null); // instantiates a new agg node
		_graph.addNode(newAggNode); // adds it to the graph
		nodes.put(newAggNode, node); // puts a new entry on our HashMap of nodes
	}
	
	/**
	 * adds a new activity diagram edge to the model;
	 * privately configures the underlying AGG graph to hold the information of such an edge
	 * @param edge
	 */
	private void addAnADEdge(ActivityEdge edge) {
		Arc newAggArc = new Arc(null, edge.getAggType(), edge.getAggSourceNode(), edge.getAggTargetNode(), null); 
		_graph.addArc(newAggArc);
		edges.put(newAggArc, edge);
	}

}
