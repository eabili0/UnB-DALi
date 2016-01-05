package br.unb.dali.models.agg;

import agg.xt_basis.GraGra;
import agg.xt_basis.Graph;
import br.unb.dali.models.IModel;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.util.agg.Misc;

/**
 * Defines the characteristics every Agg model should present;
 * 
 * Note that every subclass of $AModel should also have a corresponding agg GraGra (a resource file)
 * that defines the underlying Agg infrastructure of the model
 * @author abiliooliveira
 */
public abstract class AnAggModel implements IModel {
	protected Graph _graph;
	protected GraGra _gragra;
	
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
	 * This method sets up the model structures, based on the underlying AGG graph _graph;
	 * This will always be called by the AbstractModel Constructor
	 * 
	 * This method is implementation specific
	 * @param graph The graph that truthfully represents the model
	 */
	protected abstract void setUp();
	
	/**
	 * Indicates which is the resource file name of the agg GraGra this model is being built upon;
	 * Important for the constructor below;
	 * 
	 * Method completely implementation specific;
	 * @return the resource file name correspondent to the underlying agg GraGra of this model
	 */
	protected abstract String getGraGraResourceFileName();
	
	/**
	 * All models have to provide a way to initialize them by an AGG Graph;
	 * If the subclasses want to provide empty constructors, one only have to pass a null graph;
	 * After the model is setup, a semantic verification will be run by this constructor
	 *  
	 * This functionality will be useful for instantiating the target model in the end of a transformation.
	 * @param graph The graph that truthfully represents the model
	 * @throws ModelSemanticsVerificationException 
	 */
	public AnAggModel(Graph graph) throws ModelSemanticsVerificationException {
		_gragra = Misc.loadGraGra(getGraGraResourceFileName());
		_gragra.destroyAllGraphs();
		_graph = (graph!=null)?graph:new Graph(_gragra.getTypeSet());
		setUp();
		checkModel();
	}
}
