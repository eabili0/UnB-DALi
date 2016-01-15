package br.unb.dali.models.agg.uml.ad.nodes.executable;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.Activity;
import br.unb.dali.models.agg.uml.ad.ActivityNode;

public class ExecutableNode extends ActivityNode {

	public ExecutableNode(String id, Activity context) throws NullAggContextException, AggNodeConstructionException {
		super(id, null, context);
	}
	
	public ExecutableNode(String id, Node aggNode, Activity context) throws NullAggContextException, AggNodeConstructionException {
		super(id, aggNode, context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub
	}
	
}