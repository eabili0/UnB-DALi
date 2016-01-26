package br.unb.dali.models.agg.uml;

import agg.xt_basis.Graph;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.exceptions.AggModelConstructionException;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.models.agg.markovchains.DTMC;
import br.unb.dali.models.agg.uml.ad.edges.ControlFlow;
import br.unb.dali.models.agg.uml.ad.nodes.control.DecisionNode;
import br.unb.dali.models.agg.uml.ad.nodes.control.FinalNode;
import br.unb.dali.models.agg.uml.ad.nodes.control.InitialNode;
import br.unb.dali.models.agg.uml.ad.nodes.control.MergeNode;
import br.unb.dali.models.agg.uml.ad.nodes.executable.ExecutableNode;
import br.unb.dali.transformations.agg.AD2DTMC;
import br.unb.dali.util.io.IOHelper;

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
public class ActivityDiagram extends AbstractAggModel{
	private static final String _grammar = "/models/AD.ggx";
	private String _name;
	
	/*********************** CONSTRUCTORS ***********************/
	
	/** 
	 * Initializes a new empty UML Activity Diagram
	 * 
	 * @param id this activity diagram string identifier
	 * @param name the name of this UML 2.5 activity diagram
	 * 
	 * @throws AggModelConstructionException (should not happen with this constructor)
	 */
	public ActivityDiagram(String id, String name) throws AggModelConstructionException {
		super(id, null, _grammar);
		this._name = name;
	}
	
	/**
	 * Constructs a new UML Activity Diagram based on an AGG Graph object
	 * 
	 * @param id this activity identifier
	 * @param graph the underlying AGG Graph object
	 * 
	 * @throws AggModelConstructionException when:
	 * 	1 - any of the Graph objects are not compliant to the underlying Type Graph;
	 * 	2 - if any syntactical inconsistency is found;
	 * 	3 - when any mandatory attribute of the Graph object is not set; 
	 */
	public ActivityDiagram(Graph graph) throws AggModelConstructionException {
		super(IOHelper.getRandomString(), graph, _grammar);
	}
	
	/*********************** INHERITANCE ***********************/
	
	/**
	 * Checks if this Activity Diagram is syntactically and semantically correct
	 * 
	 * @throws ModelSemanticsVerificationException if this object is not well formed 
	 */
	public void checkModel() throws ModelSemanticsVerificationException {
		super.checkModel();
	}

	@Override
	protected void setUp() throws AggModelConstructionException {
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
	
	/**
	 * Transforms this UML Activity Diagram to a DTMC model
	 * 
	 * @param name the DTMC name to be generated
	 * @return the related DTMC Model of this Activity Diagram
	 */
	public DTMC toDTMC(String name) {
		return new AD2DTMC(this).transform().setName(name);
	}
	
	/**
	 * Transforms this UML Activity Diagram into a DTMC Model
	 * The name of the resulting DTMC will be the same as of this object.
	 *  
	 * @return the related DTMC Model of this Activity Diagram
	 */
	public DTMC toDTMC() {
		return new AD2DTMC(this).transform().setName(this._name);
	}
	
	/*********************** PRIVATE ***********************/
}
