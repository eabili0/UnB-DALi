package br.unb.dali.transformations;

import br.unb.dali.models.IModel;
import br.unb.dali.models.exceptions.ModelSemanticsVerificationException;
import agg.xt_basis.GraGra;
import agg.xt_basis.GraTra;
import agg.xt_basis.LayeredGraTraImpl;

/**
 * Defines the characteristics every transformation should present
 * @author abiliooliveira
 */
abstract class AbstractTransformation implements ITransformation {
	protected GraTra _morphism;
	protected GraGra _grammar;
	
	/**
	 * Sets up the transformation with a new Grammar, a new Transformation and the sourceModel's graph
	 * @param graph
	 * @throws ModelSemanticsVerificationException 
	 */
	public AbstractTransformation(IModel sourceModel) throws ModelSemanticsVerificationException {
		sourceModel.checkModel();
		_grammar = new GraGra(sourceModel.getGraph());
		_morphism = new LayeredGraTraImpl();
		_morphism.setGraGra(_grammar);
	}
	
	/**
	 * Gets the graph morphism object
	 * @return
	 */
	public GraTra getMorphism() {
		return _morphism;
	}

	/**
	 * Gets the graph grammar object
	 * @return
	 */
	public GraGra getGrammar() {
		return _grammar;
	}
}
