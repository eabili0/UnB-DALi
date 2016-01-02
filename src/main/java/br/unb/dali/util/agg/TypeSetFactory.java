package br.unb.dali.util.agg;

import java.lang.reflect.Modifier;

import org.reflections.Reflections;

import agg.xt_basis.Type;
import agg.xt_basis.TypeSet;

public class TypeSetFactory {
	enum QueryType {
		NODE, ARC;
	}
	
	/**
	 * Identifies the classes of a package that extends AnAggElem class and return their specific node type set 
	 * @param packageName
	 * @return
	 */
	public static TypeSet getNodeTypeSet(String packageName) {
		return getTypeSet(packageName, QueryType.NODE);
	}
	
	/**
	 * Identifies the classes of a package that extends AnAggElem class and return their specific arc type set
	 * @param packageName
	 * @return
	 */
	public static TypeSet getArcTypeSet(String packageName) {
		return getTypeSet(packageName, QueryType.ARC); 
	}
	
	/**
	 * via reflection, brings to life all the types (node or arc) inside a specific package 
	 * @param packageName
	 * @param qT
	 * @return
	 */
	private static TypeSet getTypeSet(String packageName, QueryType qT) {
		TypeSet toReturn = new TypeSet();
		Reflections r = new Reflections(packageName);
		
		switch (qT) {
			case ARC:
				for (Class<?> c : r.getSubTypesOf(IAggArc.class))
					if (!c.isInterface() && !Modifier.isAbstract(c.getModifiers())) {
						Type t = toReturn.createArcType(true);
						t.setStringRepr(c.getSimpleName());
						
					}
				break;
			case NODE:
				for (Class<?> c : r.getSubTypesOf(IAggNode.class))
					if (!c.isInterface() && !Modifier.isAbstract(c.getModifiers()))
						toReturn.createNodeType(true).setStringRepr(c.getSimpleName());
				break;
		}
		
		return toReturn;
	}
	
}
