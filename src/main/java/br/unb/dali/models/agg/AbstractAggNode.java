package br.unb.dali.models.agg;

import agg.attribute.AttrInstance;
import agg.attribute.impl.AttrTupleManager;
import agg.xt_basis.Node;
import agg.xt_basis.Type;
import br.unb.dali.models.agg.exceptions.InconsistentNodeTypeException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;

/**
 * This abstract class defines the expected behavior of any class identified as an Agg Node;
 * It is expected that the simpleName() of this class is exactly the name of the underlying agg NodeType;
 * 
 * Property {@link #_aggNode} defines the underlying agg type of this uml activity diagram node
 * Property {@link #_type} defines the underlying agg node of this uml activity diagram node
 * Property {@link #_context} defines the hidden context at which the instance of this class is at
 * 
 * @author abiliooliveira
 */
public abstract class AbstractAggNode {
	protected AbstractAggModel _context;
	protected Type _type;
	protected Node _aggNode;
	
	/**
	 * @return the underlying agg type of this node
	 */
	public Type getAggType() {
		return this._type;
	}
	
	/**
	 * @return the underlying agg node representation of this UML AD node
	 */
	public Node getAggNode() {
		return this._aggNode;
	}
	
	/**
	 * This model sets up the node structures based on the properties of _aggNode;
	 * 
	 * Every AnAggNode subclass MUST implement this method, since it is always called by the constructor below
	 */
	protected abstract void setUp();
	
	/**
	 * It is expected from every subclass to provide ways of constructing them by an 
	 * already constructed AggNode ($aggNode). This is done via the setUp() method;
	 *  
	 * Also, to obtain information regarding the underlying agg infrastructure, 
	 * we need a proper context represented here by $context; 
	 * 
	 * @param aggNode the underlying agg node; can be NULL
	 * @param context where the underlying agg information will be found; can NEVER be null
	 * @throws InconsistentNodeTypeException 
	 */
	public AbstractAggNode(Node aggNode, AbstractAggModel context) throws NullAggContextException, InconsistentNodeTypeException {
		if (context == null) throw new NullAggContextException();
		setUnderlyingInfo(aggNode, context);
		setUp();
	}
	
	/**
	 * This method sets up the attributes $_type and $_aggNode,
	 * always verifying if the information is properly set
	 * 
	 * @param aggNode the aggNode where the information will be get from; can be NULL 
	 * @param context where the underlying agg info will be found; CANNOT be NULL
	 * @throws InconsistentNodeTypeException 
	 */
	private void setUnderlyingInfo(Node aggNode, AbstractAggModel context) throws InconsistentNodeTypeException {
		_context = context;
		_type = context.getGraGra().getTypeSet().getTypeByName(this.getClass().getSimpleName());
		
		if (aggNode == null) { // info not from an agg node
			AttrInstance tt = AttrTupleManager.getDefaultManager().newInstance(
					_type.getAttrType(), null);
			_aggNode = new Node(tt, _type, context.getGraph());
		} else { // info from an agg node
			if (!aggNode.getType().getName().equals(_type.getName())) 
				// if names are inconsistent, then throw exception
				throw new InconsistentNodeTypeException();
			else {
				_aggNode = aggNode;
			} 
		}
	}
}
