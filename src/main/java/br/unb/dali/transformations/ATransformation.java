package br.unb.dali.transformations;

import agg.util.XMLHelper;
import agg.xt_basis.BaseFactory;
import agg.xt_basis.GraGra;
import agg.xt_basis.GraTra;
import agg.xt_basis.LayeredGraTraImpl;
import br.unb.dali.models.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.models.AModel;

/**
 * Defines the characteristics every transformation should present
 * @author abiliooliveira
 */
public abstract class ATransformation {
	protected GraTra _morphism;
	protected GraGra _grammar;
	
	/**
	 * Loads a new graph grammar from a file
	 * @param fileName
	 * @return
	 */
	private GraGra load(String fileName) {
		if (fileName.endsWith(".ggx")) {
			XMLHelper h = null;
			h = new XMLHelper();
			h.read_from_xml(fileName);

			// create a gragra
			GraGra gra = (GraGra) h.getTopObject(BaseFactory.theFactory().createGraGra());
			return gra;
		}
		else return null;
	}
	
	/**
	 * Sets up the transformation with the Graph Grammar given by the grammar file provided;
	 * Also sets up a new Layered Transformation.
	 * @param graph
	 * @throws ModelSemanticsVerificationException 
	 */
	public ATransformation(String fileName) {
		_grammar = load(fileName);
		_morphism = new LayeredGraTraImpl();
		_morphism.setGraGra(_grammar);
	}
	
	/**
	 * Performs the actual transformation
	 * Needs to be implemented.
	 */
	public abstract AModel transform(AModel source);
	
	/**
	 * Sets up and performs the transformation
	 * @param source
	 */
	protected void performTransformation(AModel source) {
		_morphism.setHostGraph(source.getGraph());
		_morphism.transform();
	}
	
	/**
	 * @return the graph morphis object
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
