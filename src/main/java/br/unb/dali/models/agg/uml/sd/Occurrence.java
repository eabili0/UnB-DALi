package br.unb.dali.models.agg.uml.sd;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.util.io.Misc;

public class Occurrence extends AbstractAggNode {
	private Occurrence _previous;
	private Occurrence _next;
	private Lifeline _lifeline;
	
	/********************************* CONSTRUCTORS**************************************/
	
	/**
	 * Construct a new empty Sequence Diagram Occurrence
	* @throws AggNodeConstructionException 
	* @throws NullAggContextException 
	*/
	public Occurrence(AbstractAggModel context) throws NullAggContextException, AggNodeConstructionException {
		super(Misc.getRandomString(), null, context);
	}
	
	/**
	 * Constructs a new Sequence Diagram Occurrence via underlying AGG structures
	 * @param aggNode 
	 * @param context
	 * @throws NullAggContextException
	 * @throws AggNodeConstructionException
	 */
	public Occurrence(Node aggNode, AbstractAggModel context) throws NullAggContextException, AggNodeConstructionException {
		super(Misc.getRandomString(), aggNode, context);
		// TODO Auto-generated constructor stub
	}

	/********************************* INHERITANCE **************************************/
	@Override
	protected void setUp() {
		// TODO Auto-generated method stub

	}
	
	/********************************* PUBLIC BEHAVIOR **************************************/
	
	public Occurrence getPreviousOccurrence() {
		return _previous;
	}
	
	public Occurrence setPreviousOccurrence(Occurrence occ) {
		this._previous = occ;
		return this;
	}
	
	public Occurrence getNextOccurrence(Occurrence occ) {
		return _next;
	}
	
	public Occurrence setNextOccurrence(Occurrence occ) {
		this._next = occ;
		return this;
	}
	
	public Lifeline getLifene() {
		return this._lifeline;
	}
	
	public Occurrence setLifeline(Lifeline l) {
		this._lifeline = l;
		return this;
	}
	
	
}
