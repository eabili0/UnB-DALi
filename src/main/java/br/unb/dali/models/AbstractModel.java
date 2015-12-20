package br.unb.dali.models;

import agg.xt_basis.Graph;

abstract class AbstractModel implements IModel {
	private Graph _graph;

	public Graph get_graph() {
		return _graph;
	}
	
}
