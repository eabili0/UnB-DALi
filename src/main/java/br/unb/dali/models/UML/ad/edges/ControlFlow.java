package br.unb.dali.models.uml.ad.edges;

import br.unb.dali.models.exceptions.NullabilityOfSourceAndTargetNodeException;
import br.unb.dali.models.uml.ad.ActivityEdge;
import br.unb.dali.models.uml.ad.ActivityNode;

public class ControlFlow extends ActivityEdge {

	public ControlFlow(ActivityNode source, ActivityNode target) throws NullabilityOfSourceAndTargetNodeException {
		super(source, target);
		// TODO Auto-generated constructor stub
	}

}
