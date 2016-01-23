package br.unb.dali.models.agg.uml.sd;

import java.util.ArrayList;
import java.util.List;

import agg.xt_basis.Node;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.exceptions.AggEdgeConstructionException;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.SequenceDiagram;
import br.unb.dali.models.agg.uml.sd.relations.First;
import br.unb.dali.util.io.Misc;

/**
 * A Sequence Diagram Lifeline
 * 
 * @author abiliooliveira
 */
public class Lifeline extends AbstractAggNode {
	private double _BCompRel;
	private String _name;
	private Occurrence _firstOccurrence;
	private List<Occurrence> _occurrences;
	
	/************************************* CONSTRUCTORS *************************************/
	
	/**
	 * Constructs a new empty Lifeline
	 * @param id
	 * @param context
	 * @throws AggNodeConstructionException 
	 * @throws NullAggContextException 
	 */
	public Lifeline(String id, SequenceDiagram context) throws NullAggContextException, AggNodeConstructionException {
		super(id, null, context);
	}
	
	/**
	 * Constructs a Lifeline from the underlying information of an agg node
	 * 
	 * @param aggNode
	 * @param context
	 * @throws NullAggContextException
	 * @throws AggNodeConstructionException
	 */
	public Lifeline(Node aggNode, SequenceDiagram context)
			throws NullAggContextException, AggNodeConstructionException {
		super(Misc.getRandomString(), aggNode, context);
		
		// TODO Auto-generated constructor stub
	}

	/************************************* INHERITANCE *************************************/
	@Override
	protected void setUp() {
		_occurrences = new ArrayList<Occurrence>();
		// TODO Auto-generated method stub

	}
	
	/************************************* PUBLIC BEHAVIOR *************************************/
	public String getName() {
		return _name;
	}

	public void setName(String _name) {
		this._name = _name;
	}

	public double getBCompRel() {
		return _BCompRel;
	}

	public void setBCompRel(double _BCompRel) {
		this._BCompRel = _BCompRel;
	}

	public Occurrence getFirstOccurrence() {
		return _firstOccurrence;
	}

	public void setFirstOccurrence(Occurrence _firstOccurrence) {
		this._firstOccurrence = _firstOccurrence;
	}

	public List<Occurrence> getOccurrences() {
		return _occurrences;
	}

	public void setOccurrences(ArrayList<Occurrence> _occurrences) {
		this._occurrences = _occurrences;
	}

	public Occurrence addOccurrence(Occurrence occ) throws NullAggContextException, AggEdgeConstructionException {
		_occurrences.add(occ);
		if (_occurrences.isEmpty()) {
			_firstOccurrence = occ;
			this._context.addAnAggNode(occ);
			this._context.addAnAggEdge(new First(this, occ, (SequenceDiagram)this._context));
		}
		return occ;
	}
}
