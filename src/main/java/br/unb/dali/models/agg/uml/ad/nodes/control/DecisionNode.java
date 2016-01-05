package br.unb.dali.models.agg.uml.ad.nodes.control;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.exceptions.InconsistentNodeTypeException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.Activity;
import br.unb.dali.models.agg.uml.ad.nodes.ControlNode;

public class DecisionNode extends ControlNode {

	public DecisionNode(Activity context) throws NullAggContextException, InconsistentNodeTypeException {
		super(null, context);
	}
	
	public DecisionNode(Node aggNode, Activity context) throws NullAggContextException, InconsistentNodeTypeException {
		super(aggNode, context);
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub
	}

}
