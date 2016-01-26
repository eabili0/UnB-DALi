package br.unb.dali.models.agg.uml.sd.relations;

import br.unb.dali.models.agg.AbstractAggEdge;
import br.unb.dali.models.agg.uml.SequenceDiagram;
import br.unb.dali.models.agg.uml.sd.Occurrence;
import br.unb.dali.util.io.IOHelper;

/**
 * Instancies of this class denotes a Next relation between two UML SD Lifeline Occurrences,
 * thus providing mechanism for the ordering of lifeline occurrences.
 * 
 * Since it is a relation between two model objects, it extends the AbstractAggEdge class.
 * @author abiliooliveira
 */
public class Next extends AbstractAggEdge {

	/**
	 * Constructs a new Next relations between two occurrences from the same lifelie.
	 * 
	 * @param source the source occurrence
	 * @param target the next occurrence
	 * @param context the context model
	 */
	public Next(Occurrence source, Occurrence target, SequenceDiagram context) {
		super(IOHelper.getRandomString(), source, target, context);
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub
		
	}

}
