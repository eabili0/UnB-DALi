package br.unb.dali.models.agg.markovchains;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import agg.xt_basis.Graph;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.exceptions.AggModelConstructionException;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.models.prism.PRISMModel;
import br.unb.dali.models.prism.PRISMModelTypes;
import br.unb.dali.models.prism.PRISMModule;
import br.unb.dali.util.io.Misc;

public class MultiDTMC extends AbstractAggModel {
	private ArrayList<DTMC> _dtmcs;
	
	public MultiDTMC(String id, Graph graph)
			throws AggModelConstructionException {
		super(id, graph);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkModel() throws ModelSemanticsVerificationException {
		
	}

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
	
	@Override
	protected void setUp() throws AggModelConstructionException {
		_dtmcs = new ArrayList<DTMC>();
		ArrayList<Graph> graphs = DepthFirstSearchGraphs();
		for (Graph g : graphs) {
			_dtmcs.add(new DTMC(Misc.getRandomString(), g));
		}
	}

	@Override
	protected String getGraGraResourceFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	private ArrayList<Graph> DepthFirstSearchGraphs() {
		// TODO
		return null;
	}

}
