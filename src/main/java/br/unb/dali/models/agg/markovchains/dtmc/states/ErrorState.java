package br.unb.dali.models.agg.markovchains.dtmc.states;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.markovchains.DTMC;
import br.unb.dali.models.agg.markovchains.dtmc.DTMCState;

public class ErrorState extends DTMCState {

	/**
	 * Constructs a new clean DTMC FinalState
	 * 
	 * @param id this error state identifier
	 * @param context the DTMC model that this FinalState Object will stay with; MUST NOT be NULL
	 * 
	 * @throws NullAggContextException when the context is NULL
	 * @throws AggNodeConstructionException when something wrong happend while constructing this error state
	 */
	public ErrorState(String id, DTMC context) throws NullAggContextException, AggNodeConstructionException {
		super(id, null, context);
	}
	
	/**
	 * Construct a new DTMC FinalState based on the information of an agg node
	 * 
	 * @param id this error state identifier (MUST NOT be NULL or EMPTY)
	 * @param aggNode the agg node where the info for the DTMC FinalState to be created will be found; 
	 * 	if null, has the same effect as FinalState(DTMC);
	 * @param context the DTMC model that this FinalState Object will stay with; MUST NOT be NULL
	 * 
	 * @throws NullAggContextException when the context is NULL
	 * @throws AggNodeConstructionException when something wrong
	 */
	public ErrorState(String id, Node aggNode, DTMC context) throws NullAggContextException, AggNodeConstructionException {
		super(id, aggNode, context);
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub
	}

}
