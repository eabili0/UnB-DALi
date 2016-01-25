package br.unb.dali.transformations;

/**
 * This interface should be implemented by all transformations, independent from transformation engine.
 * 
 * @author abiliooliveira
 */
public interface ITransformation<S,T> {
	
	public T transform(S source) throws Exception;
}
