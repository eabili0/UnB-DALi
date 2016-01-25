package br.unb.dali.transformations.agg;

import br.unb.dali.models.agg.markovchains.MultiDTMC;
import br.unb.dali.models.agg.uml.SequenceDiagram;

public class SD2DTMC extends AbstractAggTransformation{
	private static final String _grammar = "/transformation/SD2DTMC.ggx";
	private SequenceDiagram _sd = null;
	
	public SD2DTMC(SequenceDiagram sd) {
		super(_grammar);
	}
	
	public MultiDTMC transform() {
		return new MultiDTMC(super.transform(_sd));
	}

}
