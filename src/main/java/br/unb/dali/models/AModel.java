package br.unb.dali.models;

import br.unb.dali.models.exceptions.ModelSemanticsVerificationException;
import agg.xt_basis.Graph;
import agg.xt_basis.TypeSet;

/**
 * Defines the characteristics every model should present;
 * @author abiliooliveira
 */
public abstract class AModel {
	protected Graph _graph;
	protected TypeSet _typeSet;
	
	/**
	 * Returns the underlying graph of a Model
	 * @return the underlying AGG Graph
	 */
	public Graph getGraph() {
		return _graph;
	}
	
	/**
	 * Customly verifies if the model is sematically correct;
	 * This action depends totally on the implementing class
	 * 
	 * @throws ModelSemanticsVerificationException if the model was not correctly setup
	 */
	public abstract boolean checkModel() throws ModelSemanticsVerificationException;
	
	/**
	 * This method sets up the model structures, based on the underlying AGG graph _graph;
	 * This will always be called by the AbstractModel Constructor
	 * @param graph The graph that truthfully represents the model
	 */
	protected abstract void setUp();
	
	/**
	 * This method should be implemented to tell to AGG 
	 * which are the types available for the underlying graph;
	 * 
	 * It will always be called by this class' constructor
	 */
	protected abstract void defineTypeSet();
	
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
		defineTypeSet();
		_graph = (graph!=null)?graph:new Graph(_typeSet);
		setUp();
		checkModel();
	}
}
