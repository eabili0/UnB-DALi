package br.unb.dali.models;

import br.unb.dali.models.exceptions.ModelSemanticsVerificationException;
import agg.xt_basis.Graph;

/**
 * Defines the methods a model should implement
 * @author abiliooliveira
 */
public interface IModel {
	
	/**
	 * Returns the underlying graph of a Model
	 * @return
	 */
	public Graph getGraph();
	
	/**
	 * Customly verifies if the model was semantically well made
	 * @return
	 */
	public boolean checkModel() throws ModelSemanticsVerificationException;
}
