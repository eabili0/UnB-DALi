package br.unb.dali.models.agg.markovchains;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import agg.xt_basis.Graph;
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
	public MultiDTMC(Graph graph)
			throws AggModelConstructionException {
		super(Misc.getRandomString(), graph, _grammar);
	}

	@Override
	public void checkModel() throws ModelSemanticsVerificationException {
		
	}
	
	@Override
	protected void setUp() throws AggModelConstructionException {
		_dtmcs = new ArrayList<DTMC>();
		ArrayList<Graph> graphs = DepthFirstSearchGraphs();
		for (Graph g : graphs) {
			_dtmcs.add(new DTMC(Misc.getRandomString(), g));
		}
	}

	/**
	 * Converts this MultiDTMC model to its correspondent PRISM Model
	 * 
	 * @return the correspondent PRISM Model
	 */
	public PRISMModel toPRISM() {
		PRISMModel toReturn = new PRISMModel("", PRISMModelTypes.DTMC);
		
		for (DTMC dtmc : _dtmcs) {
			Map<String, PRISMModule> modules = dtmc.toPRISM().getModules();
			Iterator<Map.Entry<String, PRISMModule>> itr = modules.entrySet().iterator();
			while (itr.hasNext()) {
				PRISMModule module = itr.next().getValue();
				toReturn.addModule(module);
			}
		}
		return toReturn;
	}

	/**
	 * Searches for all the disconnected sub graphs
	 * @return
	 */
	private ArrayList<Graph> DepthFirstSearchGraphs() {
		// TODO
		return null;
	}

}
