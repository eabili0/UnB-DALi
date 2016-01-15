package br.unb.dali.models.agg;

import java.util.HashMap;
import java.util.Map;

import agg.xt_basis.Arc;
import agg.xt_basis.GraGra;
import agg.xt_basis.Graph;
import agg.xt_basis.Node;
import br.unb.dali.models.IModel;
import br.unb.dali.models.agg.exceptions.AggModelConstructionException;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.util.agg.Misc;

/**
 * Defines the characteristics every Agg model should present;
 * 
 * Note that every subclass of $AModel should also have a corresponding agg GraGra (a resource file)
 * that defines the underlying Agg infrastructure of the model
 * 
 * Property {@link #_graph} defines the Agg graph that is being invisibly created by actions performed in the instance class
 * Property {@link #_gragra} defines the underlying Agg infrastructure of this model
 * Property {@link #_edges} defines the activity edges as a map of AGG Arcs to ActivityEdges
 * Property {@link #_nodes} defines the activity nodes as a map of AGG Nodes to ActivityNodes
 * 
 * @author abiliooliveira
 */
public abstract class AbstractAggModel implements IModel {
	protected Graph _graph;
	protected GraGra _gragra;
	protected Map<Node, AbstractAggNode> _nodes;
	protected Map<Arc, AbstractAggEdge> _edges;
	protected String _id;
	
	/********************** PUBLIC BEHAVIOR **************************/
	
	/**
	 * Return the underlying infrastructure of this model
	 * @return
	 */
	public GraGra getGraGra() {
		return _gragra;
	}
	
	/**
	 * Returns the underlying graph of a Model
	 * @return the underlying AGG Graph
	 */
	public Graph getGraph() {
		return _graph;
	}
	
	/**
	 * Customly verifies if the model is sematically correct;
	 * This method is implementation specific
	 * 
	 * @throws ModelSemanticsVerificationException if the model was not correctly setup
	 */
	public abstract boolean checkModel() throws ModelSemanticsVerificationException;
	
	/**
	 * Searches for an activity node based on an agg node
	 * @param n
	 * @return the agg node n correspondent activity node
	 */
	public AbstractAggNode searchNode(Node n) {
		return _nodes.getOrDefault(n, null);
	}
	
	/**
	 * @return the underlying model id
	 */
	public String getId() {
		return _id;
	}

	/********************** PROTECTED BEHAVIOR **************************/
	
	/**
	 * adds a new AbstractAggNode node to the model;
	 * privately configures the underlying AGG graph to hold the information of such a node
	 * @param node
	 */
	protected void addAnAggNode(AbstractAggNode node) {
		_graph.addNode(node.getAggNode()); // adds it to the graph
		_nodes.put(node.getAggNode(), node); // puts a new entry on our HashMap of nodes
	}
	
	/**
	 * adds a new AbstractAggEdge edge to the model;
	 * privately configures the underlying AGG graph to hold the information of such an edge
	 * @param edge
	 */
	protected void addAnAggEdge(AbstractAggEdge edge) {
		_graph.addArc(edge.getAggArc());
		_edges.put(edge.getAggArc(), edge);
	}
	
	/**
	 * This method sets up the model structures, based on the underlying AGG graph _graph;
	 * This will always be called by the AbstractModel Constructor
	 * 
	 * This method is implementation specific
	 * @param graph The graph that truthfully represents the model
	 */
	protected abstract void setUp() throws AggModelConstructionException;
	
	/**
	 * Indicates which is the resource file name of the agg GraGra this model is being built upon;
	 * Important for the constructor below;
	 * 
	 * Method completely implementation specific;
	 * @return the resource file name correspondent to the underlying agg GraGra of this model
	 */
	protected abstract String getGraGraResourceFileName();
	
	/********************** CONSTRUCTORS **************************/
	
	/**
	 * All models have to provide a way to initialize them by an AGG Graph;
	 * If the subclasses want to provide empty constructors, one only have to pass a null graph;
	 * After the model is setup, a semantic verification will be run by this constructor
	 *  
	 * This functionality will be useful for instantiating the target model in the end of a transformation.
	 * 
	 * @param id this model identifier 
	 * @param graph The graph that truthfully represents the model
	 * @throws AggModelConstructionException 
	 */
	public AbstractAggModel(String id, Graph graph) throws AggModelConstructionException {
		_gragra = Misc.loadGraGra(getGraGraResourceFileName());
		_gragra.destroyAllGraphs();
		_graph = (graph!=null)?graph:new Graph(_gragra.getTypeSet());
		_gragra.resetGraph(_graph.copy(_gragra.getTypeSet()));
		
		if (!_gragra.checkGraphConsistency(_graph))
			throw new AggModelConstructionException("Underlying Graph model does not respect the consistency conditions imposed.");
		if (id == null || id.isEmpty())
			throw new AggModelConstructionException("A null or empty id is not acceptable.");
		
		_id = id;
		_nodes = new HashMap<Node, AbstractAggNode>();
		_edges = new HashMap<Arc, AbstractAggEdge>();
		setUp();
		checkModel();
	}
}
