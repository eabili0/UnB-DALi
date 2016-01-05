package br.unb.dali.util.agg;

import agg.util.XMLHelper;
import agg.xt_basis.BaseFactory;
import agg.xt_basis.GraGra;

public final class Misc {
	
	/**
	 * Loads a new graph grammar from a file
	 * @param fileName
	 * @return the respective Graph Grammar
	 */
	public static GraGra loadGraGra(String resourceName) {
		String fileName = Thread.currentThread().getContextClassLoader().getResource(resourceName).getFile();
		if (fileName.endsWith(".ggx")) {
			XMLHelper h = null;
			h = new XMLHelper();
			h.read_from_xml(fileName);

			// create a gragra
			GraGra gra = (GraGra) h.getTopObject(BaseFactory.theFactory().createGraGra());
			return gra;
		}
		else return null;
	}
	
}
