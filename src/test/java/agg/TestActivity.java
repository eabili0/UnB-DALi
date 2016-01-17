package agg;

import br.unb.dali.models.agg.markovchains.DTMC;
import br.unb.dali.models.agg.uml.Activity;
import br.unb.dali.models.agg.uml.ad.edges.ControlFlow;
import br.unb.dali.models.agg.uml.ad.nodes.control.FinalNode;
import br.unb.dali.models.agg.uml.ad.nodes.control.InitialNode;
import br.unb.dali.models.agg.uml.ad.nodes.executable.ExecutableNode;
import br.unb.dali.util.io.Misc;



public class TestActivity {
	
	public static void main(String[] args) {
		try {
			// ids representing: an initial node, an executable node and a final node
			String[] nodeIDs = new String[] {Misc.getRandomString(), Misc.getRandomString(),Misc.getRandomString()};
			String[][] cfs = new String[][] {
					{Misc.getRandomString(), nodeIDs[0], nodeIDs[1], "1.0" },
					{Misc.getRandomString(), nodeIDs[1], nodeIDs[2], "1.0"}
			};
			
			Activity ad = new Activity(Misc.getRandomString());
			
			ad.addInitialNode(new InitialNode(nodeIDs[0], ad));
			ad.addExecutableNode(new ExecutableNode(nodeIDs[1], ad));
			ad.addFinalNode(new FinalNode(nodeIDs[2], ad));
			
			ad.addControlFlow(new ControlFlow(cfs[0][0], cfs[0][1], cfs[0][2], ad)
				.setPTS(Double.parseDouble(cfs[0][3])));
			ad.addControlFlow(new ControlFlow(cfs[1][0], cfs[1][1], cfs[1][2], ad)
				.setPTS(Double.parseDouble(cfs[1][3])));
			
			DTMC dtmc = ad.toDTMC("Teste");
			
			System.out.println(dtmc.toPRISM());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
