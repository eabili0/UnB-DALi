package br.unb.dali.models.agg.markovchains.dtmc;

import agg.attribute.AttrInstance;
import agg.xt_basis.Node;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;

public abstract class DTMCState extends AbstractAggNode {
	protected int _index;
	protected String _label;
	protected String _dtmc;
	
	public DTMCState(String id, Node aggNode, AbstractAggModel context) throws NullAggContextException, AggNodeConstructionException {
		super(id, aggNode, context);
		if (aggNode == null) 
			this._index = context.getNumberOfNodes();
	}
	
	public int getIndex() {
		return _index;
	}
	
	public String getLabel() {
		return _label;
	}
	
	public String getDTMCName() {
		return _dtmc;
	}
	
	@Override
	protected void setUp() {
		AttrInstance attrs = _aggNode.getAttribute();
		Object value = attrs.getValueAt("label");
		if (value != null)
			_label = (String)value;
		
		value = attrs.getValueAt("index");
		if (value != null )
			_index = (int)value;
		
		value = attrs.getValueAt("dtmc");
		if (value != null)
			_dtmc = (String)value;
	}

}
