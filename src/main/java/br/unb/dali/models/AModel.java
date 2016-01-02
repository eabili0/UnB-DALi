package br.unb.dali.models;

import br.unb.dali.models.exceptions.ModelSemanticsVerificationException;
import agg.xt_basis.Graph;

/**
 * Defines the characteristics every model should present;
 * @author abiliooliveira
 */
public abstract class AModel {
	protected Graph _graph;

	/**
	 * Returns the underlying graph of a Model
	 * @return the underlying AGG Graph
	 */
	public Graph getGraph() {
		return _graph;
	}
	
	/**
	 * Customly verifies if the model was semantically well made
	 * @return true if the model is semantically correct, false otherwise
	 */
	public abstract boolean checkModel() throws ModelSemanticsVerificationException;
	
	/**
	 * This method sets up the model structures from a given graph;
	 * This will always be called by the AbstractModel Constructor, whenever the graph is not null.
	 * @param graph The graph that truthfully represents the model
	 */
	protected abstract void setUp(Graph graph);
	
	/**
	 * All models have to provide a way to initialize them by an AGG Graph;
	 * If the subclasses want to provide empty constructors, one only have to pass a null graph;
	 * After the model is setup, a semantic verification will be run by this constructor
	 * 
	 * This functionality will be useful for instantiating the target model in the end of a transformation.
	 * @param graph The graph that truthfully represents the model
	 * @throws ModelSemanticsVerificationException 
	 */
	public AModel(Graph graph) throws ModelSemanticsVerificationException {
		if (graph != null) {
			setUp(graph);
			checkModel();
		}
	}
}
