package br.unb.dali.models;

/**
 * This interface should be implemented by all models,
 * independent from transformation engine;
 * 
 * May be useful in the future;
 * @author abiliooliveira
 */
public interface IModel {
	public void checkModel() throws Exception;
}
