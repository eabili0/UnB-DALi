package br.unb.dali.models.agg.exceptions;

public class NullArcException extends AggEdgeConstructionException {
	private static final long serialVersionUID = -4694018777409661199L;

	public NullArcException() {
		super("The AbstractAggEdge constructor with signature (Arc, AbstractAggModel) does not accept null arcs!");
	}
}
