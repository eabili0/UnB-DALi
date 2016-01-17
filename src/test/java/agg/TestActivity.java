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
			
			ad.addControlFlow(new ControlFlow(cfs[0][0], cfs[0][1], cfs[0][2], ad));
			ad.addControlFlow(new ControlFlow(cfs[1][0], cfs[1][1], cfs[1][2], ad));
			
			DTMC dtmc = ad.toDTMC();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		try {
//			Activity ad = new Activity();
//			try {
//				InitialNode i = new InitialNode(ad);
//				ExecutableNode e = new ExecutableNode(ad);
//				FinalNode f = new FinalNode(ad);
//				
//				ad.addInitialNode(i);
//				ad.addExecutableNode(e);
//				ad.addFinalNode(f);
//				
//				ad.addControlFlow(new ControlFlow(i, e, ad).setProbability(1.0));
//				ad.addControlFlow(new ControlFlow(e, f, ad).setProbability(1.0));
//				
//				DTMC dtmc = ad.toDTMC();
//				System.out.println(dtmc.getGraph());
//				
//			} catch (NullAggContextException | AggNodeConstructionException | AggEdgeConstructionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (AggModelConstructionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		};
	}
}
