package br.unb.dali.models.agg.exceptions;

public class NullTargetOfAggEdgeException extends AggEdgeConstructionException {
	private static final long serialVersionUID = 1478346598960076585L;

	public NullTargetOfAggEdgeException() {
		super("The agg edge constructor (AbstractAggNode, AbstractAggNode, AbstractAggModel) cannot have a null target!");
	}
}
