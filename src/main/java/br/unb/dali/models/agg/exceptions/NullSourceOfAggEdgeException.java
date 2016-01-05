package br.unb.dali.models.agg.exceptions;

public class NullSourceOfAggEdgeException extends Exception {
	private static final long serialVersionUID = -2834750274155369381L;
	
	public NullSourceOfAggEdgeException() {
		super("The agg edge constructor (AnAggNode, AnAggNode, AnAggModel) cannot have a null source!");
	}
}
