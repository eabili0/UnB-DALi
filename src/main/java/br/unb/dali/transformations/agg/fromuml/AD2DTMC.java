package br.unb.dali.transformations.agg.fromuml;

import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.models.agg.markovchains.DTMC;
import br.unb.dali.transformations.agg.AbstractAggTransformation;

public class AD2DTMC extends AbstractAggTransformation {
	private static final String resourceName = "/transformations/AD2DTMC.ggx";
	
	public AD2DTMC() {
		super(resourceName);
	}

	@Override
	public AbstractAggModel transform(AbstractAggModel source) throws ModelSemanticsVerificationException {
		return new DTMC(this.performTransformation(source));
	}

}
