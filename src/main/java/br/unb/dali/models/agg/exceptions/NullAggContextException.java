package br.unb.dali.models.agg.exceptions;

public class NullAggContextException extends Exception {
	private static final long serialVersionUID = -2866533730493967362L;
	
	public NullAggContextException() {
		super("One can never instantiate Model elements without instantiating the Model first");
	}
	
}
