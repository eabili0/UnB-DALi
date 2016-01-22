package br.unb.dali.models.agg.uml;

import agg.xt_basis.Graph;
import br.unb.dali.models.agg.AbstractAggModel;
import br.unb.dali.models.agg.exceptions.AggModelConstructionException;
import br.unb.dali.models.agg.exceptions.ModelSemanticsVerificationException;
import br.unb.dali.util.io.Misc;

/**
 * This class represents the UML Sequence Diagram Model for Dependability Analysis.
 * It's underlying infrastructure relies on the AGG Engine.
 * 
 * @author abiliooliveira
 */
public class SequenceDiagram extends AbstractAggModel {
	private static final String _grammar = "/models/SD.ggx";
	
	/**
	 * Constructs a new empty Sequence Diagram.
	 * 
	 * @param id the identification string of this Model
	 * @throws AggModelConstructionException (impossible with this constructor)
	 */
	public SequenceDiagram(String id) throws AggModelConstructionException {
		super(id, null, _grammar);
	}
	
	/**
	 * Constructs a Sequence Diagram from an AGG Graph object
	 *  
	 * @param graph the AGG Graph object
	 * @throws AggModelConstructionException 
	 * 	1 - if any of the objects of this Graph is not compatible with the type graph of this Model;
	 * 	2 - if syntactical errors are found;
	 * 	3 - if mandatory attributes are missing
	 */
	public SequenceDiagram(Graph graph) throws AggModelConstructionException {
		super(Misc.getRandomString(), graph, _grammar);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Checks the integrity of this Model
	 */
	@Override
	public void checkModel() throws ModelSemanticsVerificationException {
		if (!_gragra.checkGraphConsistency(_graph)) {
			throw new ModelSemanticsVerificationException("The underlying AGG Graph is not consistent with the syntactical constraints of its Type Graph!");
		}
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub

	}

}
