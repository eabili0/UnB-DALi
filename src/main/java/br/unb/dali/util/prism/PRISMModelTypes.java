package br.unb.dali.util.prism;

public enum PRISMModelTypes {
	DTMC("dtmc");
	
	private String _description;
	
	PRISMModelTypes(String description) {
		this._description = description;
	}
	
	@Override
	public String toString() {
		return _description;
	}
}
