package br.unb.dali.models.agg.uml.ad.nodes;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.Activity;
import br.unb.dali.models.agg.uml.ad.ActivityNode;

public abstract class ControlNode extends ActivityNode {

	public ControlNode(Activity context) throws NullAggContextException, AggNodeConstructionException {
		super(null, context);
	}
	
	public ControlNode(Node aggNode, Activity context) throws NullAggContextException, AggNodeConstructionException {
		super(aggNode, context);
	}
	
}
