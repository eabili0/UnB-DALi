package br.unb.dali.models.uml;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import agg.xt_basis.Arc;
import agg.xt_basis.Graph;
import agg.xt_basis.Node;
import br.unb.dali.models.AModel;
import br.unb.dali.models.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.models.uml.ad.AnADEdge;
import br.unb.dali.models.uml.ad.AnADNode;
import br.unb.dali.models.uml.ad.nodes.FinalActivity;
import br.unb.dali.models.uml.ad.nodes.InitialActivity;

public class ActivityDiagram extends AModel{
	private InitialActivity init;
	private Map<Node,AnADNode> nodes;
	private Map<Arc, AnADEdge> edges;
	private HashSet<FinalActivity> finals;
	
	/** 
	 * Initializes a new UML Activity Diagram
	 * @throws ModelSemanticsVerificationException
	 */
	public ActivityDiagram() throws ModelSemanticsVerificationException {
		super(null);
	}
	
	/**
	 * Initializes a new UML Activity Diagram with an Initial Activity
	 * @param init
	 * @throws ModelSemanticsVerificationException
	 */
	public ActivityDiagram(InitialActivity init) throws ModelSemanticsVerificationException {
		this();
		this.init = init;
		addAnADNode(init);
	}
	
	public ActivityDiagram(Graph graph) throws ModelSemanticsVerificationException {
		super(graph);
	}

	@Override
	public boolean checkModel() throws ModelSemanticsVerificationException {
		// TODO Auto-generated method stub
		if (init == null) return false;
		return false;
	}

	@Override
	protected void setUp() {
		// init our repositories of nodes and edges
		this.nodes = new HashMap<Node, AnADNode>();
		this.edges = new HashMap<Arc,AnADEdge>();
		
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * adds a new activity diagram node to the model;
	 * privately configures the underlying AGG graph to hold the information of such a node
	 * @param node
	 */
	public void addAnADNode(AnADNode node) {
		Node newAggNode = new Node(null, node.getAggType(), null);
		_graph.addNode(newAggNode);
		nodes.put(newAggNode, node);
		if (node instanceof FinalActivity) {
			finals.add((FinalActivity)node);
		}
		
	}
	
	/**
	 * adds a new activity diagram edge to the model;
	 * privately configures the underlying AGG graph to hold the information of such an edge
	 * @param edge
	 */
	public void addAnADEdge(AnADEdge edge) {
		Arc newAggArc = new Arc(null, edge.getAggType(), edge.getAggSourceNode(), edge.getAggTargetNode(), null); 
		_graph.addArc(newAggArc);
		edges.put(newAggArc, edge);
	}

	@Override
	protected void defineTypeSet() {
		this._typeSet = UMLTypeSetUtil.ADTypeSet;
	}

}
