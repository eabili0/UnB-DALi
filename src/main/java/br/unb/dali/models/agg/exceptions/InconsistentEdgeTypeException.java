package br.unb.dali.models.agg.exceptions;

public class InconsistentEdgeTypeException extends AggEdgeConstructionException {
	private static final long serialVersionUID = 122507026940522764L;

	public InconsistentEdgeTypeException() {
		super("The type of the agg edge passed in the constructor of an AbstractAggEdge subclass does not correspond to the subclass name!");
	}
}
