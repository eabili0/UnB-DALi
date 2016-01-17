package br.unb.dali.models.agg.markovchains.dtmc.states;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.markovchains.DTMC;
import br.unb.dali.models.agg.markovchains.dtmc.DTMCState;

public class State extends DTMCState {

	/**
	 * Constructs a new clean DTMC State
	 * 
	 * @param id this state identifier
	 * @param context the DTMC model that this State Object will stay with; MUST NOT be NULL
	 * 
	 * @throws NullAggContextException when the context is NULL
	 * @throws AggNodeConstructionException when something wrong happens while constructing this node
	 */
	public State(String id, DTMC context) throws NullAggContextException, AggNodeConstructionException {
		super(id, null, context);
	}
	
	/**
	 * Construct a new DTMC State based on the information of an agg node
	 * 
	 * @param id this state identifier
	 * @param aggNode the agg node where the info for the DTMC State to be created will be found; 
	 * 	if null, has the same effect as State(DTMC);
	 * @param context the DTMC model that this State Object will stay with; MUST NOT be NULL
	 * 
	 * @throws NullAggContextException when the context is NULL
	 * @throws AggNodeConstructionException when something wrong happens while constructing this state
	 */
	public State(String id, Node aggNode, DTMC context) throws NullAggContextException, AggNodeConstructionException {
		super(id, aggNode, context);
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub

	}

}
