package br.unb.dali.models.prism;

import java.util.ArrayList;
import java.util.List;

/**
 * This class makes up for a high-level representation of a PRISM Module
 *
 * Property {@link #_variables} holds the strings of the variable declarations in PRISM language
 * Property {@link #_commands} holds the strings of the commands in PRISM language
 * Property {@link #_name} is the given name of this PRISM Module
 * 
 * @author abiliooliveira
 */
public class PRISMModule {
	private String _name;
	private List<String> _variables;
	private List<String> _commands;
	
	/********************************* CONSTRUCTORS *******************************/
	
	/**
	 * Constructs a new PRISM Module
	 * @param name
	 */
	public PRISMModule(String name) {
		this._name = name;
		_variables = new ArrayList<String>();
		_commands = new ArrayList<String>();
	}
	
	/********************************* PUBLIC BEHAVIOR *******************************/
	
	/**
	 * @return the name given to this PRISM Module
	 */
	public String getName() {
		return _name;
	}
	
	/**
	 * @return the variables of this PRISM Module
	 */
	public List<String> getVariables() {
		return _variables;
	}
	
	/**
	 * Adds a new variable declaration to this PRISM Module
	 * @param variable the string of the declaration
	 * @return this
	 */
	public PRISMModule addVariable(String variable) {
		this._variables.add("\t"+variable+"\n");
		return this;
	}
	
	/**
	 * @return the commands of this PRISM Module
	 */
	public List<String> getCommands() {
		return _commands;
	}
	
	/**
	 * Adds a new command to this PRISM Module
	 * @param command the string of the command to be added
	 * @return this
	 */
	public PRISMModule addCommand(String command) {
		if (command != null && !command.isEmpty())
			this._commands.add("\t" + command + "\n");
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder("module " + this._name + "\n");
		
		// prints the variables first
		for (String var : this._variables) {
			buffer.append(var);
		}
		buffer.append("\n"); // separates the two regions
		
		// prints the commands second
		for (String command : this._commands) {
			buffer.append(command);
		}
		
		buffer.append("endmodule\n");
		return buffer.toString();
	}
	
	/********************************* PRIVATE BEHAVIOR *******************************/
}
