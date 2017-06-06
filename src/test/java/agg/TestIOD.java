package agg;

import br.unb.dali.models.agg.uml.InteractionOverviewDiagram;
import br.unb.dali.models.agg.uml.SequenceDiagram;
import br.unb.dali.models.agg.uml.sd.Lifeline;
import br.unb.dali.util.io.IOHelper;

public class TestIOD {

	public static void main (String[] args) {
		try {
			String[] ids = { IOHelper.getRandomString(), IOHelper.getRandomString(), IOHelper.getRandomString() };
			InteractionOverviewDiagram iod = new InteractionOverviewDiagram(IOHelper.getRandomString(), "Teste");
			
			iod.addInitialNode(ids[0], "");
			iod.addInteractionUse(ids[1], getScenario(), "");
			iod.addFinalNode(ids[2], "");
			
			iod.addControlFlow(IOHelper.getRandomString(), ids[0], ids[1], 0.9);
			iod.addControlFlow(IOHelper.getRandomString(), ids[1], ids[2], 0.95);
			
			
			System.out.println(iod.toDTMC().toPRISM());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static SequenceDiagram getScenario() {
		String l1Id = IOHelper.getRandomString();
		String l2Id = IOHelper.getRandomString();
		
		SequenceDiagram sd = new SequenceDiagram(IOHelper.getRandomString(), "GasPump");
	
		sd.addLifeline(new Lifeline(l1Id, "User", sd).setBCompRel(0.8));
		sd.addLifeline(new Lifeline(l2Id, "GasPump", sd).setBCompRel(0.99));
		
		sd.addAsyncMessage(IOHelper.getRandomString(), l1Id, l2Id, "insertCard");
		sd.addAsyncMessage(IOHelper.getRandomString(), l2Id, l1Id, "response");
		
		return sd;
	}
}
