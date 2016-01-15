package br.unb.dali.models.agg.markovchains.dtmc;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;

public abstract class DTMCState extends AbstractAggNode {

	public DTMCState(String id, Node aggNode, AbstractAggModel context)
			throws NullAggContextException, AggNodeConstructionException {
		super(id, aggNode, context);
		// TODO Auto-generated constructor stub
	}

}
