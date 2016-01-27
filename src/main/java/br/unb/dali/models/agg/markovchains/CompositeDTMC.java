package br.unb.dali.models.agg.markovchains;

import java.util.ArrayList;
import java.util.List;

import br.unb.dali.util.prism.PRISMModel;
import br.unb.dali.util.prism.PRISMModelTypes;

/**
 * Instancies of this class holds multiple MiltiDTMCs
 * 
 * @author abiliooliveira
 */
public class CompositeDTMC {
	List<MultiDTMC> _dtmcs;
	
	/**
	 * Constructs a new Composite DTMC
	 */
	public CompositeDTMC() {
		_dtmcs = new ArrayList<MultiDTMC>();
	}
	
	/**
	 * adds a multi dtmc to this composite dtmc
	 * @param dtmc
	 * @return the added MultiDTMC
	 */
	public MultiDTMC addMultiDTMC(MultiDTMC dtmc) {
		_dtmcs.add(dtmc);
		return dtmc;
	}
	
	/**
	 * Converts this CompositeDTMC to a PRISM DTMC Model
	 * @return a PRISM DTMC Model
	 */
	public PRISMModel toPRISM() {
		PRISMModel toReturn = new PRISMModel("", PRISMModelTypes.DTMC);
		
		for (MultiDTMC dtmc : _dtmcs) {
			toReturn.addModules(dtmc.toPRISM().getModules().values());
		}
		
		return toReturn;
	}
}
