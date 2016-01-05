package br.unb.dali.models.agg.markovchains;

import agg.xt_basis.Graph;
import br.unb.dali.models.agg.AnAggModel;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;

public class DTMC extends AnAggModel {
	private static final String gragra = "models/DTMC.ggx";
	
	public DTMC() throws ModelSemanticsVerificationException {
		super(null);
	}
	
	public DTMC(Graph graph) throws ModelSemanticsVerificationException {
		super(graph);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkModel() throws ModelSemanticsVerificationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getGraGraResourceFileName() {
		return gragra;
	}

}
