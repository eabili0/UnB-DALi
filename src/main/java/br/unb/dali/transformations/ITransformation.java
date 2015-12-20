package br.unb.dali.transformations;

import br.unb.dali.models.IModel;

/**
 * Defines the methods a transformation should implement
 * @author abiliooliveira
 */
public interface ITransformation {

	/**
	 * Applies the transformation, returning the target model
	 */
	public IModel transform();
	
}
