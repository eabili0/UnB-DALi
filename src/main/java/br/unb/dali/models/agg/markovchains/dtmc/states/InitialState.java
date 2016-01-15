package br.unb.dali.models.agg.markovchains.dtmc.states;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.markovchains.DTMC;

public class InitialState extends AbstractAggNode {

	/**
	 * Constructs a new clean DTMC InitialState
	 * 
	 * @param id this initial state identifier (MUST NOT be NULL or EMPTY)
	 * @param context the DTMC model that this InitialState Object will stay with; MUST NOT be NULL
	 * 
	 * @throws NullAggContextException when the context is NULL
	 * @throws AggNodeConstructionException when something wrong happens while constructing this initial state
	 */
	public InitialState(String id, AbstractAggModel context) throws NullAggContextException, AggNodeConstructionException {
		super(id, null, context);
	}
	
	/**
	 * Construct a new DTMC InitialState based on the information of an agg node
	 * 
	 * @param id this initial state identifier (MUST NOT be NULL or EMPTY)
	 * @param aggNode the agg node where the info for the DTMC InitialState to be created will be found; 
	 * 	if null, has the same effect as InitialState(DTMC);
	 * @param context the DTMC model that this InitialState Object will stay with; MUST NOT be NULL
	 * 
	 * @throws NullAggContextException when the context is NULL
	 * @throws AggNodeConstructionException when something wrong happens while constructing this initial state
	 */
	public InitialState(String id, Node aggNode, DTMC context) throws NullAggContextException, AggNodeConstructionException {
		super(id, aggNode, context);
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub
	}

}
