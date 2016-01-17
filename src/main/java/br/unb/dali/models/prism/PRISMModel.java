package br.unb.dali.models.prism;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import br.unb.dali.models.IModel;

/**
 * The high-level structure of a PRISM Model
 * 
 * Property {@link #_type} identifies the type of this PRISM Model
 * Property {@link #_name} is the name of this PRISM Model
 * Property {@link #_modules} holds the modules of this PRISM Model
 * 
 * @author abiliooliveira
 */
public class PRISMModel implements IModel {
	private String _type;
	private String _name;
	private Map<String, PRISMModule> _modules;
	
	
	/************************************* PUBLIC BEHAVIOR *********************************/
	
	/**
	 * Constructs a new PRISM Model
	 * @param name the name given to the this Model
	 */
	public PRISMModel(String name, PRISMModelTypes type) {
		_modules = new HashMap<String, PRISMModule>();
		_name = name;
		_type = type.toString();
	}
	
	/************************************* PUBLIC BEHAVIOR *********************************/
	
	/**
	 * @return the type of this PRISM Model
	 */
	public String getType() {
		return _type; 
	}
	
	/**
	 * @return the name given to this PRISM Model
	 */
	public String getName() {
		return _name;
	}

	/**
	 * @return the modules that compose this PRISM Model
	 */
	public Map<String, PRISMModule> getModules() {
		return _modules;
	}
	
	/**
	 * Adds a new module to this PRISM Model
	 * @param module
	 * @return this
	 */
	public PRISMModel addModule(PRISMModule module) {
		this._modules.put("", module);
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder(_type + "\n");
		
		Iterator<Entry<String, PRISMModule>> moduleIterator = _modules.entrySet().iterator();
		while (moduleIterator.hasNext()) {
			buffer.append("\n");
			buffer.append(moduleIterator.next().getValue());
		}
		
		return buffer.toString();
	}
	
	/************************************* PRIVATE BEHAVIOR *********************************/
}
