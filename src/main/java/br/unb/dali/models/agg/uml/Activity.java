package br.unb.dali.models.agg.uml;

import agg.xt_basis.Graph;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.exceptions.AggModelConstructionException;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;
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
public class Activity extends AbstractAggModel{
	private static final String gragra = "models/AD.ggx";
	
	/*********************** CONSTRUCTORS ***********************/
	
	/** 
	 * Initializes a new UML Activity Diagram
	 * @throws AggModelConstructionException
	 */
	public Activity() throws AggModelConstructionException {
		super(null);
	}
	
	/**
	 * Constructs a new UML Activity Diagram based on an AGG graph
	 * @param graph
	 * @throws AggModelConstructionException
	 */
	public Activity(Graph graph) throws AggModelConstructionException {
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
		// TODO Auto-generated method stub
		
	}
	
	/*********************** PUBLIC ***********************/
	
	/**
	 * Adds a new ControlFlow edge to this UML Activity Diagram 
	 * @param edge
	 */
	public void addControlFlow(ControlFlow edge) {
		addAnAggEdge(edge);
	}
	
	/**
	 * Adds a new DecisionNode node to this UML Activity Diagram
	 * @param node
	 */
	public void addDecisionNode(DecisionNode node) {
		addAnAggNode(node);
	}
	
	/**
	 * Adds a new FinalNode node to this UML Activity Diagram 
	 * @param node
	 */
	public void addFinalNode(FinalNode node) {
		addAnAggNode(node);
	}
	
	/**
	 * Adds a new Initialnode node to this UML Activity Diagram
	 * @param node
	 */
	public void addInitialNode(InitialNode node) {
		addAnAggNode(node);
	}
	
	/**
	 * Adds a new MergeNode node to this UML Activity Diagram
	 * @param node
	 */
	public void addMergeNode(MergeNode node) {
		addAnAggNode(node);
	}
	
	/**
	 * Adds a new ExecutableNode node to this UML Activity Diagram
	 * @param node
	 */
	public void addExecutableNode(ExecutableNode node) {
		addAnAggNode(node);
	}
	
	/*********************** PRIVATE ***********************/
}
