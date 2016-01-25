package br.unb.dali.models.agg.uml.sd;

import java.util.ArrayList;
import java.util.List;

import agg.attribute.AttrInstance;
import br.unb.dali.models.agg.AbstractAggNode;
import br.unb.dali.models.agg.uml.SequenceDiagram;
import br.unb.dali.models.agg.uml.sd.occurrences.Event;

/**
 * An UML Sequence Diagram Lifeline
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
	 * Constructs a new empty Lifeline.
	 * 
	 * @param id a string identifier for this object
	 * @param context this object's model context
	 */
	public Lifeline(String id, String name, SequenceDiagram context) {
		super(id, null, context);
		this._name = name;
	}
	
	/**
	 * Constructs a Lifeline from the underlying information of an agg node
	 * 
	 * @param aggNode
	 * @param context
	 */
//	public Lifeline(Node aggNode, SequenceDiagram context) {
//		super(Misc.getRandomString(), aggNode, context);
//		
//		// TODO Auto-generated constructor stub
//	}

	/************************************* INHERITANCE *************************************/
	@Override
	protected void setUp() {
		_occurrences = new ArrayList<Occurrence>();
		AttrInstance attrs = _aggNode.getAttribute();
		Object value = attrs.getValueAt("name");
		if (value != null) _name = (String)value;
		value = attrs.getValueAt("BCompRel");
		if (value != null) _BCompRel = (double)value;
	}
	
	/************************************* PUBLIC BEHAVIOR *************************************/

	/**
	 * Adds a new Message Event to this Lifeline
	 * @param occ
	 * @return the added message event
	 */
	public Event addEvent(Event occ) {
		addOccurrence(occ);
		return occ;
	}
	
	/**
	 * Adds a new occurrence to this lifeline.
	 * @param occ
	 * @return the added occurrence
	 */
	private Occurrence addOccurrence(Occurrence occ) {
		_occurrences.add(occ);
		if (_occurrences.isEmpty()) {
			_firstOccurrence = occ;
		}
		return occ;
	}
	
	
	/**
	 * @return the first occurrence in this lifeline
	 */
	public Occurrence getFirstOccurrence() {
		return _firstOccurrence;
	}

	/**
	 * @return the list of occurrences in this lifeline
	 */
	public List<Occurrence> getOccurrences() {
		return _occurrences;
	}
	
	/**
	 * @return the last occurrence of this lifeline
	 */
	public Occurrence getLastOccurrence() {
		return _occurrences.get(_occurrences.size()-1);
	}
	
	/**
	 * @return the name attributed to this lifeline
	 */
	public String getName() {
		return _name;
	}

	/**
	 * Sets the name of this Lifeline
	 * @param _name the name
	 * @return the lifeline itself
	 */
	public Lifeline setName(String name) {
		this._name = name;
		return this;
	}

	/**
	 * @return the reliability of the component identified by this lifeline
	 */
	public double getBCompRel() {
		return _BCompRel;
	}

	/**
	 * Sets the reliability of the component identified by this lifiline.
	 * 
	 * @param _BCompRel the reliability associated with this lifeline: 0 <= reliability <= 1
	 * @return the lifeline itself
	 */
	public Lifeline setBCompRel(double BCompRel) {
		if (BCompRel > 1 || BCompRel < 0) 
			throw new RuntimeException("The reliability value MUST be between 0 and 1!");
		this._BCompRel = BCompRel;
		return this;
	}
}
