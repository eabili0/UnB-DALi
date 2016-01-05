package br.unb.dali.models.agg.exceptions;

public class InconsistentNodeTypeException extends Exception {
	private static final long serialVersionUID = -4582688514668535947L;

	public InconsistentNodeTypeException() {
		super("The type of the agg node passed in the constructor of an AnAggNode subclass does not correspond to the subclass name!");
	}
}
