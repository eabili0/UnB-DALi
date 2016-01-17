package br.unb.dali.models.agg.uml;

import agg.xt_basis.Graph;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.exceptions.AggModelConstructionException;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;

public class SequenceDiagram extends AbstractAggModel {

	public SequenceDiagram(String id, Graph graph) throws AggModelConstructionException {
		super(id, graph);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkModel() throws ModelSemanticsVerificationException {
		if (!_gragra.checkGraphConsistency(_graph)) {
			throw new ModelSemanticsVerificationException("");
		}
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getGraGraResourceFileName() {
		// TODO Auto-generated method stub
		return null;
	}

}
