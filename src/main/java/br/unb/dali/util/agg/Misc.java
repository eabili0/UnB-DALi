package br.unb.dali.util.agg;

import java.io.InputStream;

import agg.xt_basis.BaseFactory;
import agg.xt_basis.GraGra;

public final class Misc {
	
	/**
	 * Loads a new graph grammar from a file
	 * @param fileName
	 * @return the respective Graph Grammar
	 */
	public static GraGra loadGraGra(String resourceName) {
		if (resourceName.endsWith(".ggx")) {
			InputStream xml = Thread.currentThread().getClass().getResourceAsStream(resourceName);
	
			CustomXMLHelper h = new CustomXMLHelper();
			h.read_from_xml(xml);
	
			// create a gragra
			GraGra gra = (GraGra) h.getTopObject(BaseFactory.theFactory().createGraGra());
			return gra;
		}
		return null;
	}
	
}
