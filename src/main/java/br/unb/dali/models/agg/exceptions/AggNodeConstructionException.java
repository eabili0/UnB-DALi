package br.unb.dali.models.agg.exceptions;

public class AggNodeConstructionException extends RuntimeException {
	private static final long serialVersionUID = 1747047437331756540L;

	public AggNodeConstructionException() {
		super("Error when trying to construct a new UnB-DALi Agg Node!");
	}
	
	public AggNodeConstructionException(String desc) {
		super(desc);
	}
}
