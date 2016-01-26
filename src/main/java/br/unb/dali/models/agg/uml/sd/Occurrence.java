package br.unb.dali.models.agg.uml.sd;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.util.io.IOHelper;

/**
 * Instancies of this Class denote occurrences on UML Sequence Diagram Lifelines.
 * 
 * @author abiliooliveira
 */
public abstract class Occurrence extends AbstractAggNode {
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
		super(IOHelper.getRandomString(), null, context);
	}
	
	/**
	 * Constructs a new Sequence Diagram Occurrence via underlying AGG structures
	 * @param aggNode 
	 * @param context
	 * @throws NullAggContextException
	 * @throws AggNodeConstructionException
	 */
	public Occurrence(Node aggNode, AbstractAggModel context) throws NullAggContextException, AggNodeConstructionException {
		super(IOHelper.getRandomString(), aggNode, context);
		// TODO Auto-generated constructor stub
	}

	/********************************* INHERITANCE **************************************/
	@Override
	protected void setUp() {
		// TODO Auto-generated method stub
	}
	
	/********************************* PUBLIC BEHAVIOR **************************************/
	
	/**
	 * @return the previous occurrence
	 */
	public Occurrence getPreviousOccurrence() {
		return _previous;
	}
	
	/**
	 * Sets the previous occurrence object
	 * @param occ the previous occurrence
	 * @return this occurrence
	 */
	public Occurrence setPreviousOccurrence(Occurrence occ) {
		this._previous = occ;
		return this;
	}
	
	/**
	 * @return the next occurrence
	 */
	public Occurrence getNextOccurrence() {
		return _next;
	}
	
	/**
	 * Sets the next occurrence object
	 * @param occ the next occurrence
	 * @return this occurrence
	 */
	public Occurrence setNextOccurrence(Occurrence occ) {
		this._next = occ;
		return this;
	}
	
	/**
	 * @return the associated lifeline of this occurrence
	 */
	public Lifeline getLifene() {
		return this._lifeline;
	}
	
	/**
	 * Sets the lifeline that this occurrence belongs to
	 * @param l the lifeline of this occurrence
	 * @return this occurrence
	 */
	public Occurrence setLifeline(Lifeline l) {
		this._lifeline = l;
		return this;
	}
	
	
}
