package br.unb.dali.transformations.agg;

import br.unb.dali.models.agg.markovchains.MultiDTMC;
import br.unb.dali.models.agg.uml.SequenceDiagram;

/**
 * Transforms an UML 2.5 Sequence Diagram object to a Multi DTMC Model object 
 *   
 * @author abiliooliveira
 */
public class SD2DTMC extends AggLayeredTransformation{
	private static final String _grammar = "/transformations/SD2DTMC.ggx";
	private SequenceDiagram _sd = null;
	
	/**
	 * Constructs a new SD2DTMC agg layered transformation
	 * @param sd the source model, an UML 2.5 Sequence Diagram
	 */
	public SD2DTMC(SequenceDiagram sd) {
		super(_grammar);
		_sd = sd;
	}
	
	/**
	 * Transforms this UML 2.5 Sequence Diagram to its respective DTMC Model
	 * @return the corresponding target Model, a Multi DTMC
	 */
	public MultiDTMC transform() {
		return new MultiDTMC(super.transform(_sd));
	}

}
