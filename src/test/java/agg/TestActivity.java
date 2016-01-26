package agg;

import br.unb.dali.models.agg.markovchains.DTMC;
import br.unb.dali.models.agg.uml.ActivityDiagram;
import br.unb.dali.models.agg.uml.ad.edges.ControlFlow;
import br.unb.dali.models.agg.uml.ad.nodes.control.FinalNode;
import br.unb.dali.models.agg.uml.ad.nodes.control.InitialNode;
import br.unb.dali.models.agg.uml.ad.nodes.executable.ExecutableNode;
import br.unb.dali.util.io.IOHelper;

public class TestActivity {
	
	public static void main(String[] args) {
		
		try {
			// ids representing: an initial node, an executable node and a final node
			String[] nodeIDs = new String[] {IOHelper.getRandomString(), IOHelper.getRandomString(),IOHelper.getRandomString()};
			String[][] cfs = new String[][] {
					{IOHelper.getRandomString(), nodeIDs[0], nodeIDs[1] },
					{IOHelper.getRandomString(), nodeIDs[1], nodeIDs[2]}
			};
			
			ActivityDiagram ad = new ActivityDiagram(IOHelper.getRandomString(), "Teste");
			
			ad.addInitialNode(new InitialNode(nodeIDs[0], ad));
			ad.addExecutableNode(new ExecutableNode(nodeIDs[1], ad));
			ad.addFinalNode(new FinalNode(nodeIDs[2], ad));
			
			ad.addControlFlow(new ControlFlow(cfs[0][0], cfs[0][1], cfs[0][2], ad)
				.setPTS(0.7));
			ad.addControlFlow(new ControlFlow(cfs[1][0], cfs[1][1], cfs[1][2], ad)
				.setPTS(0.3));
			
			DTMC dtmc = ad.toDTMC();
			
			System.out.println(dtmc.toPRISM());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
