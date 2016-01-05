package br.unb.dali.models.agg.markovchains.dtmc;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.exceptions.InconsistentNodeTypeException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;

public abstract class DTMCState extends AbstractAggNode {

	public DTMCState(Node aggNode, AbstractAggModel context)
			throws NullAggContextException, InconsistentNodeTypeException {
		super(aggNode, context);
		// TODO Auto-generated constructor stub
	}

}
