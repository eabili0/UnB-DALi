package br.unb.dali.models.uml.ad.edges;

import br.unb.dali.models.exceptions.NullabilityOfSourceAndTargetNodeException;
import br.unb.dali.models.uml.ad.AnADEdge;
import br.unb.dali.models.uml.ad.AnADNode;

public class ControlFlow extends AnADEdge {

	public ControlFlow(AnADNode source, AnADNode target) throws NullabilityOfSourceAndTargetNodeException {
		super(source, target);
		// TODO Auto-generated constructor stub
	}

}
