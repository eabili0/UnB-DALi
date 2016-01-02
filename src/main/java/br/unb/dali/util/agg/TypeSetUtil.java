package br.unb.dali.util.agg;

import agg.xt_basis.TypeSet;

public abstract class TypeSetUtil {
	
	/**
	 * builds an agg type set from the classes of a specific packageName 
	 * @param packageName
	 * @return
	 */
	protected static TypeSet getTypeSet(String packageName) {
		TypeSet toReturn = new TypeSet();
		TypeSet nodes = TypeSetFactory.getNodeTypeSet(packageName);
		TypeSet edges = TypeSetFactory.getArcTypeSet(packageName);
		
		toReturn.adaptTypes(nodes, false);
		toReturn.adaptTypes(edges, false);
		
		return toReturn;
	}
}
