package br.unb.dali.transformations.agg;

import agg.xt_basis.GraGra;
import agg.xt_basis.GraTra;
import agg.xt_basis.Graph;
import agg.xt_basis.LayeredGraTraImpl;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.transformations.ITransformation;
import br.unb.dali.util.agg.Misc;

/**
 * Defines the characteristics every transformation should present
 * @author abiliooliveira
 */
public class GenericAggTransformation implements ITransformation<AbstractAggModel, Graph> {
	protected GraTra _morphism;
	protected GraGra _grammar;
	
	/**
	 * Sets up the transformation with the Graph Grammar given by the resource file identified by $fileName;
	 * @param fileName the resource fileName
	 */
	public GenericAggTransformation(String fileName) {
		_grammar = Misc.loadGraGra(fileName);
		_grammar.destroyAllGraphs();
		_morphism = new LayeredGraTraImpl();
		_morphism.setGraGra(_grammar);
	}
	
//	/**
//	 * Performs the actual transformation, calling the performTransformation method or not;
//	 * Needs to be implemented, so the target model can be instantiated
//	 */
//	public abstract AbstractAggModel transform(AbstractAggModel source) throws ModelSemanticsVerificationException;
//	
	/**
	 * Sets up the source graph and performs the transformation
	 * @param source
	 * @throws ModelSemanticsVerificationException 
	 * @throws Exception 
	 */
	@Override
	public Graph transform(AbstractAggModel source) throws ModelSemanticsVerificationException {
		source.checkModel();
		Graph graph = source.getGraph().copy(_grammar.getTypeSet());
		if (_grammar.resetGraph(graph)) {
			_morphism.setHostGraph(graph);
			_morphism.transform();
		} else {
			System.out.println("Source graph could not be imported to the Trasformation grammar.");
			return null;
		}
		return _morphism.getHostGraph();
	}
	
	/**
	 * @return the graph morphism object
	 */
	public GraTra getMorphism() {
		return _morphism;
	}

	/**
	 * @return the graph grammar object
	 */
	public GraGra getGrammar() {
		return _grammar;
	}
}
