package br.unb.dali.models.agg.uml.ad.nodes;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.exceptions.InconsistentNodeTypeException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.Activity;
import br.unb.dali.models.agg.uml.ad.ActivityNode;

public abstract class ControlNode extends ActivityNode {

	public ControlNode(Activity context) throws NullAggContextException, InconsistentNodeTypeException {
		super(null, context);
	}
	
	public ControlNode(Node aggNode, Activity context) throws NullAggContextException, InconsistentNodeTypeException {
		super(aggNode, context);
	}
	
}
