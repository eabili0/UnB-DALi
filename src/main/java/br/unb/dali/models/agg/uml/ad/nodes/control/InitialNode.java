package br.unb.dali.models.agg.uml.ad.nodes.control;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.Activity;
import br.unb.dali.models.agg.uml.ad.nodes.ControlNode;

public class InitialNode extends ControlNode {

	public InitialNode(Activity context) throws NullAggContextException, AggNodeConstructionException {
		super(null, context);
	}
	
	public InitialNode(Node aggNode, Activity context) throws NullAggContextException, AggNodeConstructionException {
		super(aggNode, context);
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub
	}

}
