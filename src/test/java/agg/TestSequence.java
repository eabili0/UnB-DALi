package agg;

import br.unb.dali.models.agg.uml.SequenceDiagram;
import br.unb.dali.models.agg.uml.sd.Lifeline;
import br.unb.dali.util.io.IOHelper;

public class TestSequence {

	public static void main(String[] args) {
		String l1Id = IOHelper.getRandomString();
		String l2Id = IOHelper.getRandomString();
		
		SequenceDiagram sd = new SequenceDiagram(IOHelper.getRandomString(), "Teste");
	
		sd.addLifeline(new Lifeline(l1Id, "User", sd).setBCompRel(0.8));
		sd.addLifeline(new Lifeline(l2Id, "GasPump", sd).setBCompRel(0.99));
		
		sd.addAsyncMessage(IOHelper.getRandomString(), l1Id, l2Id, "insertCard");
		sd.addAsyncMessage(IOHelper.getRandomString(), l2Id, l1Id, "response");
		
		System.out.println(sd.toDTMC().toPRISM());
	}
}
