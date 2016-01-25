package br.unb.dali.models.agg.exceptions;

public class AggEdgeConstructionException extends RuntimeException {
	private static final long serialVersionUID = 4258376057952843758L;

	public AggEdgeConstructionException() {
		super("Error when trying to construct a new UnB-DALi Agg Edge!");
	}
	
	public AggEdgeConstructionException(String desc) {
		super(desc);
	}
	
}

