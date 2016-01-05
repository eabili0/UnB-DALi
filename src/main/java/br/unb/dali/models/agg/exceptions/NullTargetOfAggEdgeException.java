package br.unb.dali.models.agg.exceptions;

public class NullTargetOfAggEdgeException extends Exception {
	private static final long serialVersionUID = 1478346598960076585L;

	public NullTargetOfAggEdgeException() {
		super("The agg edge constructor (AnAggNode, AnAggNode, AnAggModel) cannot have a null target!");
	}
}
