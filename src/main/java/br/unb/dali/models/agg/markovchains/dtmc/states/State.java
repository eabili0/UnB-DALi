package br.unb.dali.models.agg.markovchains.dtmc.states;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.exceptions.InconsistentNodeTypeException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.markovchains.DTMC;

public class State extends AbstractAggNode {

	/**
	 * Constructs a new clean DTMC State
	 * 
	 * @param context the DTMC model that this State Object will stay with; MUST NOT be NULL
	 * @throws NullAggContextException when the context is NULL
	 * @throws InconsistentNodeTypeException will never happen with this constructor
	 */
	public State(DTMC context) throws NullAggContextException, InconsistentNodeTypeException {
		super(null, context);
	}
	
	/**
	 * Construct a new DTMC State based on the information of an agg node
	 * 
	 * @param aggNode the agg node where the info for the DTMC State to be created will be found; 
	 * 	if null, has the same effect as State(DTMC);
	 * @param context the DTMC model that this State Object will stay with; MUST NOT be NULL
	 * @throws NullAggContextException when the context is NULL
	 * @throws InconsistentNodeTypeException if the name of the type of aggNode does NOT equal State 
	 */
	public State(Node aggNode, DTMC context) throws NullAggContextException, InconsistentNodeTypeException {
		super(aggNode, context);
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub

	}

}
