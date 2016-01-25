package br.unb.dali.transformations.agg;

import br.unb.dali.models.agg.markovchains.DTMC;
import br.unb.dali.models.agg.uml.ActivityDiagram;

/**
 * Transforms a UML 2.5 Activity Diagram object to an DTMC object 
 *   
 * @author abiliooliveira
 */
public class AD2DTMC extends AbstractAggTransformation {
	private static final String _grammar = "/transformations/AD2DTMC.ggx"; 
	private ActivityDiagram _ad = null;
	
	/**
	 * Constructs a new AD2DTMC agg transformation.
	 * @param ad the source model, an UML 2.5 Activity Diagram
	 */
	public AD2DTMC(ActivityDiagram ad) {
		super(_grammar);
		_ad = ad;
	}
	
	/**
	 * Transforms this' UML 2.5 Activity Diagram to its respective DTMC Model
	 * @return the corresponding DTMC Model
	 */
	public DTMC transform() {
		return new DTMC(super.transform(_ad));
	}
}
