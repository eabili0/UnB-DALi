package br.unb.dali.transformations.agg;

import agg.xt_basis.GraGra;
import agg.xt_basis.GraTra;
import agg.xt_basis.Graph;
import agg.xt_basis.LayeredGraTraImpl;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.transformations.ITransformation;
import br.unb.dali.util.agg.AggHelper;

/**
 * Defines the characteristics every transformation involving Agg obejects should present.
 * 
 * @author abiliooliveira
 */
public abstract class AggLayeredTransformation implements ITransformation<AbstractAggModel, Graph> {
	protected GraTra _gratra;
	protected GraGra _gragra;
	
	/**
	 * Sets up the transformation with the Graph Grammar given by the resource file identified by $fileName;
	 * @param fileName the resource fileName
	 */
	public AggLayeredTransformation(String fileName) {
		_gragra = AggHelper.loadGraGra(fileName);
		_gragra.destroyAllGraphs();
		_gratra = new LayeredGraTraImpl();
//		_gratra = new MyTraImpl();
//		_gratra.setCompletionStrategy(CompletionStrategySelector.getDefault());
		_gratra.setGraGra(_gragra);
	}
	
	/**
	 * Sets up the source graph and performs the transformation
	 * @param source
	 * @throws ModelSemanticsVerificationException 
	 * @throws Exception 
	 */
	@Override
	public Graph transform(AbstractAggModel source) throws ModelSemanticsVerificationException {
		source.checkModel();
		Graph graph = source.getGraph().copy(_gragra.getTypeSet());
		if (_gragra.resetGraph(graph)) {
			_gratra.setHostGraph(graph);
			_gratra.transform();
		} else {
			System.out.println("Source graph could not be imported to the Trasformation grammar.");
			return null;
		}
		return _gratra.getHostGraph();
	}
	
	/**
	 * @return the graph morphism object
	 */
	public GraTra getMorphism() {
		return _gratra;
	}

	/**
	 * @return the graph grammar object
	 */
	public GraGra getGrammar() {
		return _gragra;
	}
}
