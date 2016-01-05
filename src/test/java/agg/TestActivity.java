package agg;

import br.unb.dali.models.agg.exceptions.AggEdgeConstructionException;
import br.unb.dali.models.agg.exceptions.AggModelConstructionException;
import br.unb.dali.models.agg.exceptions.AggNodeConstructionException;
import br.unb.dali.models.agg.exceptions.NullAggContextException;
import br.unb.dali.models.agg.uml.Activity;
import br.unb.dali.models.agg.uml.ad.edges.ControlFlow;
import br.unb.dali.models.agg.uml.ad.nodes.control.FinalNode;
import br.unb.dali.models.agg.uml.ad.nodes.control.InitialNode;
import br.unb.dali.models.agg.uml.ad.nodes.executable.ExecutableNode;


public class TestActivity {
	
	public static void main(String[] args) {
		try {
			Activity ad = new Activity();
			try {
				InitialNode i = new InitialNode(ad);
				ExecutableNode e = new ExecutableNode(ad);
				FinalNode f = new FinalNode(ad);
				
				ad.addInitialNode(i);
				ad.addExecutableNode(e);
				ad.addFinalNode(f);
				
				ad.addControlFlow(new ControlFlow(i, e, ad).setProbability(1.0));
				ad.addControlFlow(new ControlFlow(e, f, ad).setProbability(1.0));
				
				
			} catch (NullAggContextException | AggNodeConstructionException | AggEdgeConstructionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AggModelConstructionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
