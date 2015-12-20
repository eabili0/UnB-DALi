package br.unb.dali.models;

import br.unb.dali.models.exceptions.ModelSemanticsVerificationException;
import agg.xt_basis.Graph;

/**
 * Defines the characteristics every model should present;
 * @author abiliooliveira
 */
abstract class AbstractModel implements IModel {
	protected Graph _graph;

	public Graph getGraph() {
		return _graph;
	}
	
	/**
	 * This method sets up the model structures from a given graph;
	 * This will always be called by the AbstractModel Constructor, whenever the graph is not null.
	 * @param graph The graph that truthfully represents the model
	 */
	protected abstract void setUp(Graph graph);
	
	/**
	 * All models have to provide a way to initialize them by a Graph;
	 * If the subclasses want to provide empty constructors, one only have to pass a null graph;
	 * After the model is setup, a semantic verification will be run by this constructor
	 * 
	 * This functionality will be useful for instantiating the target model in the end of a transformation.
	 * @param graph The graph that truthfully represents the model
	 * @throws ModelSemanticsVerificationException 
	 */
	public AbstractModel(Graph graph) throws ModelSemanticsVerificationException {
		if (graph != null) {
			setUp(graph);
			checkModel();
		}
	}
}
