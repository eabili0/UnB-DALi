package br.unb.dali.models.agg.markovchains;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import agg.xt_basis.Graph;
import agg.xt_basis.TypeException;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.exceptions.AggModelConstructionException;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.util.io.Misc;
import br.unb.dali.util.prism.PRISMModel;
import br.unb.dali.util.prism.PRISMModelTypes;
import br.unb.dali.util.prism.PRISMModule;

public class MultiDTMC extends AbstractAggModel {
	private static final String _grammar = "/models/DTMC.ggx";
	private ArrayList<DTMC> _dtmcs;
	private String _name;
	
	/************************** CONSTRUCTORS ****************************/
	
	/**
	 * Constructs a new empty MultiDTMC model
	 * 
	 * @param id the string identifier of the new object
	 */
	public MultiDTMC(String id) throws AggModelConstructionException {
		super(id, null, _grammar);
	}
	
	/**
	 * Constructs a MultiDTMC model from an AGG Graph object.
	 * 
	 * @param graph the underlying AGG Graph object
	 * @throws AggModelConstructionException when:
	 * 	1 - the type of the graph elements are not present in the Type Graph;
	 *  2 - syntactical inconsistencies are found;
	 *  3 - mandatory attributes are not set;
	 */
	public MultiDTMC(Graph graph) throws AggModelConstructionException {
		super(Misc.getRandomString(), graph, _grammar);
	}

	/************************** INHERITANCE ****************************/
	@Override
	public void checkModel() throws ModelSemanticsVerificationException {
		if (!_gragra.checkGraphConsistency(_graph)) {
			throw new ModelSemanticsVerificationException("");
		}
	}
	
	@Override
	protected void setUp() throws AggModelConstructionException {
		_dtmcs = new ArrayList<DTMC>();
		try {
			List<Graph> graphs = br.unb.dali.util.agg.Misc.getStronglyConnectedComponents(_graph);

			for (Graph g : graphs) {
				_dtmcs.add(new DTMC(g));
			}
		} catch (TypeException e) { }
	}

	/************************** PUBLIC BEHAVIOR ****************************/
	
	/**
	 * Converts this MultiDTMC model to its correspondent PRISM Model
	 * 
	 * @return the correspondent PRISM Model
	 */
	public PRISMModel toPRISM() {
		PRISMModel toReturn = new PRISMModel(this._name, PRISMModelTypes.DTMC);
		PRISMModule toReturnModule = new PRISMModule(this._name);
		
		for (DTMC dtmc : _dtmcs) {
			Iterator<PRISMModule> itr = dtmc.toPRISM().getModules().values().iterator();
			while (itr.hasNext()) {
				PRISMModule module = itr.next();
				toReturnModule.appendCommands(module);
				toReturnModule.appendVariables(module);
			}
		}
		
		toReturn.addModule(toReturnModule);
		return toReturn;
	}
}
