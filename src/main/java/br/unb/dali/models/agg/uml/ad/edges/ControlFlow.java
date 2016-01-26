package br.unb.dali.models.agg.uml.ad.edges;

import agg.attribute.AttrInstance;
import agg.xt_basis.Arc;
import br.unb.dali.models.agg.exceptions.AggEdgeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.ActivityDiagram;
import br.unb.dali.models.agg.uml.ad.ActivityEdge;
import br.unb.dali.models.agg.uml.ad.ActivityNode;

public class ControlFlow extends ActivityEdge {
	private double _PTS;
	
	/**
	 * Constructs a control flow edge based on an agg arc 
	 * 
	 * @param id this control flow identifier
	 * @param arc the agg arc where the information to construct this ControlFlow will get from
	 * @param context the uml acitivy diagram where this ControlFlow will be inserted in
	 * 
	 * @throws NullAggContextException if the context is null
	 * @throws AggEdgeConstructionException if an error occurs while constructing this ControlFlow
	 * 	with the information from arc
	 */
	public ControlFlow(String id, Arc arc, ActivityDiagram context) throws NullAggContextException, AggEdgeConstructionException {
		super(id, arc, context);
	}
	
	/**
	 * Constructs a new control flow edge
	 * 
	 * @param id this control flow identifier
	 * @param source the source activity node
	 * @param target the target activity node
	 * @param activity the UML activity diagram where this ControlFlow will be inserted in
	 * 
	 * @throws NullAggContextException if the context is null
	 * @throws AggEdgeConstructionException if an error occurs while constructing the ControlFlow
	 *  with the information from source and target
	 */
	public ControlFlow(String id, ActivityNode source, ActivityNode target, ActivityDiagram context) throws NullAggContextException, AggEdgeConstructionException {
		super(id, source, target, context);
	}
	
	/**
	 * Constructs a new control flow from the source and target ids
	 * 
	 * @param id this control flow string identifier
	 * @param sourceId the string identifier of the source node
	 * @param targetId the string identifier of the target node
	 * @param context the activity diagram where we'll be able to find the source and target nodes
	 * 
	 * @throws NullAggContextException if the context is null
	 * @throws AggEdgeConstructionException if something unnexpected happens while constructing this object
	 */
	public ControlFlow(String id, String sourceId, String targetId, ActivityDiagram context) throws NullAggContextException, AggEdgeConstructionException {
		super(id, sourceId, targetId, context);
	}

	@Override
	protected void setUp() {
		// here goes all the logic to get the attributes of this control flow from an agg arc 
		AttrInstance attrs = _aggArc.getAttribute();
		Object value = attrs.getValueAt("PTS");
		if (value != null)
			_PTS = (double)value;
	}
	
	/**
	 * Sets the PTS property of this control flow
	 * 
	 * @param PTS 
	 */
	public ControlFlow setPTS(double PTS) {
		_PTS = PTS;
		_aggArc.getAttribute().setValueAt(PTS, "PTS");
		return this;
	}
	
	/**
	 * Sets the PTS property from a Number object
	 * @param PTS the probability associated with this control flow object
	 * @return this
	 */
	public ControlFlow setPTS(Number PTS) {
		return setPTS(PTS.doubleValue());
	}
	
	/**
	 * @return the PTS (the probability of transition) of this control flow
	 */
	public double getPTS() {
		return _PTS;
	}

}
