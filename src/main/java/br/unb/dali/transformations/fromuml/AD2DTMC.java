package br.unb.dali.transformations.fromuml;

import br.unb.dali.models.AModel;
import br.unb.dali.models.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.models.markovchains.DTMC;
import br.unb.dali.transformations.ATransformation;

public class AD2DTMC extends ATransformation {
	private static final String resourceName = "transformations/AD2DTMC.ggx";
	
	public AD2DTMC() {
		super(resourceName);
	}

	@Override
	public AModel transform(AModel source) throws ModelSemanticsVerificationException {
		this.performTransformation(source);
		return new DTMC(_morphism.getHostGraph());
	}

}
