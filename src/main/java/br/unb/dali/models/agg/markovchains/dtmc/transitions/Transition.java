package br.unb.dali.models.agg.markovchains.dtmc.transitions;

import agg.attribute.AttrInstance;
import agg.xt_basis.Arc;
import br.unb.dali.models.agg.AbstractAggEdge;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.exceptions.AggEdgeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.markovchains.DTMC;

public class Transition extends AbstractAggEdge {
	private double _probability;
	
	/**
	 * Constructs a DTMC Transtion from an agg graph arc
	 * 
	 * @param id this transition identifier
	 * @param arc an proper agg arc
	 * @param context the context in which this transition will belong to
	 * 
	 * @throws NullAggContextException if the context is null
	 * @throws AggEdgeConstructionException if something wrong happens while constructing this transition
	 */
	public Transition(String id, Arc arc, DTMC context) throws NullAggContextException, AggEdgeConstructionException {
		super(id, arc, context);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructs a new DTMC Transtion
	 * 
	 * @param id this transition identifier
	 * @param source the DTMC source node
	 * @param target the DTMC target node
	 * @param context the DTMC context
	 * 
	 * @throws NullAggContextException if the context is null
	 * @throws AggEdgeConstructionException if something wrong happens while constructing this transition
	 */
	public Transition(String id, AbstractAggNode source, AbstractAggNode target, DTMC context) 
			throws NullAggContextException, AggEdgeConstructionException {
		super(id, source, target, context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() {
		// here goes all the logic to get the attributes of this control flow from an agg arc 
		AttrInstance attrs = _aggArc.getAttribute();
		Object value = attrs.getValueAt("probability");
		if (value != null)
			setProbability((Number)value);
	}

	/**
	 * @return the probability at which this transition can happen
	 */
	public double getProbability() {
		return _probability;
	}

	/**
	 * sets the probability of this transition
	 * @param _probability
	 */
	public Transition setProbability(double probability) {
		this._probability = probability;
		_aggArc.getAttribute().setValueAt(probability, "probability");
		return this;
	}
	
	/**
	 * sets the probability of this transition from a number object
	 * @param probability 
	 * @return this
	 */
	public Transition setProbability(Number probability) {
		return setProbability(probability.doubleValue());
	}

}
