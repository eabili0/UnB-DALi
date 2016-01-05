package br.unb.dali.models.agg.uml.ad.edges;

import agg.attribute.AttrInstance;
import agg.xt_basis.Arc;
import br.unb.dali.models.agg.exceptions.AggEdgeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.Activity;
import br.unb.dali.models.agg.uml.ad.ActivityEdge;
import br.unb.dali.models.agg.uml.ad.ActivityNode;

public class ControlFlow extends ActivityEdge {
	private double _probability;
	
	/**
	 * Constructs a control flow edge based on an agg arc 
	 * 
	 * @param arc the agg arc where the information to construct this ControlFlow will get from
	 * @param context the uml acitivy diagram where this ControlFlow will be inserted in
	 * @throws NullAggContextException if the context is null
	 * @throws AggEdgeConstructionException if an error occurs while constructing this ControlFlow
	 * 	with the information from arc
	 */
	public ControlFlow(Arc arc, Activity context) throws NullAggContextException, AggEdgeConstructionException {
		super(arc, context);
	}
	
	/**
	 * Constructs a new control flow edge
	 * 
	 * @param source the source activity node
	 * @param target the target activity node
	 * @param activity the UML activity diagram where this ControlFlow will be inserted in
	 * @throws NullAggContextException if the context is null
	 * @throws AggEdgeConstructionException if an error occurs while constructing the ControlFlow
	 *  with the information from source and target
	 */
	public ControlFlow(ActivityNode source, ActivityNode target, Activity context) throws NullAggContextException, AggEdgeConstructionException {
		super(source, target, context);
	}

	@Override
	protected void setUp() {
		// here goes all the logic to get the attributes of this control flow from an agg arc 
		AttrInstance attrs = _aggArc.getAttribute();
		_probability = (double)attrs.getValueAt("probability");
	}
	
	/**
	 * Sets the probability of this control flow
	 * 
	 * @param probability 
	 */
	public void setProbability(double probability) {
		_probability = probability;
		_aggArc.getAttribute().setValueAt(probability, "probability");
	}
	
	/**
	 * Gets the probability set to this control flow
	 * @return
	 */
	public double getProbability() {
		return _probability;
	}

}
