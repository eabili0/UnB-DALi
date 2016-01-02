package br.unb.dali.models.uml;

import agg.xt_basis.TypeSet;
import br.unb.dali.util.agg.TypeSetUtil;

public class UMLTypeSetUtil extends TypeSetUtil {
	public static final TypeSet ADTypeSet = getADTypeSet();
	public static final TypeSet SDTYpeSet = getSDTypeSet();
	public static final TypeSet IODTypeSet = getIODTypeSet();
	
	/**
	 * builds an agg type set for an uml activity diagram via reflection
	 * @return
	 */
	private static TypeSet getADTypeSet() {
		return getTypeSet("br.unb.dali.models.uml.ad");
	}

	/**
	 * builds an agg type set for an uml sequence diagram via reflection
	 * @return
	 */
	private static TypeSet getSDTypeSet() {
		return getTypeSet("br.unb.dali.models.uml.sd");
	}
	
	/**
	 * builds an agg type set for an uml interaction overview diagram via reflection
	 * @return
	 */
	private static TypeSet getIODTypeSet() {
		return getTypeSet("br.unb.dali.models.uml.iod");
	}
}
