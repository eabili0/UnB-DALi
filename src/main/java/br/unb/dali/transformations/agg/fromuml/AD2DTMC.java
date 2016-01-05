package br.unb.dali.transformations.agg.fromuml;

import br.unb.dali.models.agg.AnAggModel;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.models.agg.markovchains.DTMC;
import br.unb.dali.transformations.agg.AnAggTransformation;

public class AD2DTMC extends AnAggTransformation {
	private static final String resourceName = "transformations/AD2DTMC.ggx";
	
	public AD2DTMC() {
		super(resourceName);
	}

	@Override
	public AnAggModel transform(AnAggModel source) throws ModelSemanticsVerificationException {
		this.performTransformation(source);
		return new DTMC(_morphism.getHostGraph());
	}

}
