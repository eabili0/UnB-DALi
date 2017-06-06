package unbdali;

import br.unb.dali.models.agg.exceptions.AggModelConstructionException;
import br.unb.dali.models.agg.uml.ActivityDiagram;
import br.unb.dali.models.agg.uml.ad.edges.ControlFlow;
import br.unb.dali.models.agg.uml.ad.nodes.control.DecisionNode;
import br.unb.dali.models.agg.uml.ad.nodes.control.FinalNode;
import br.unb.dali.models.agg.uml.ad.nodes.control.InitialNode;
import br.unb.dali.models.agg.uml.ad.nodes.control.MergeNode;
import br.unb.dali.models.agg.uml.ad.nodes.executable.ExecutableNode;

public class TestAD2DTMC {
	
	public static void main(String[] args) {
		try {
			int k = 10;  
			double[] results = new double[k];
			String result = "";
			
			for (int i = 0; i<k; i++) {
				long start = System.currentTimeMillis();
//				result = test1().toDTMC().toPRISM().toString(); // OK
//				result = test2().toDTMC().toPRISM().toString(); // ERR - OK
//				result = test3().toDTMC().toPRISM().toString(); // ERR - OK
//				result = test4().toDTMC().toPRISM().toString(); // OK
//				result = test5().toDTMC().toPRISM().toString(); // OK
//				result = test6().toDTMC().toPRISM().toString(); // OK
//				result = test7().toDTMC().toPRISM().toString(); // OK
//				result = test8().toDTMC().toPRISM().toString(); // ERR - OK
//				result = test9().toDTMC().toPRISM().toString(); // ERR - OK
				result = test10(100).toDTMC().toPRISM().toString();
				results[i] = (double)System.currentTimeMillis() - start;
			}
			
			Statistics stats = new Statistics(results);
			System.out.println("Model:\n\n" + result);
			System.out.println("--------------------");
			System.out.println("Statistics:\n Mean: " + stats.getMean() + "ms StdDeviation:" + stats.getStdDev() + "ms");
		} catch (AggModelConstructionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	public static ActivityDiagram test1() {
		ActivityDiagram ad = new ActivityDiagram("ad", "Teste1");
		
		ad.addInitialNode(new InitialNode("i", ad));
		ad.addFinalNode(new FinalNode("f", ad));
		
		ad.addControlFlow(new ControlFlow("c1", "i", "f", ad).setPTS(1.0));
		
		return ad;
	}
	
	public static ActivityDiagram test2() {
		ActivityDiagram ad = new ActivityDiagram("ad", "Teste1");
		
		ad.addInitialNode(new InitialNode("i", ad));
		ad.addFinalNode(new FinalNode("f", ad));
		
		ad.addControlFlow(new ControlFlow("c1", "i", "f", ad));
		
		return ad;
	}
	
	public static ActivityDiagram test3() {
		ActivityDiagram ad = new ActivityDiagram("ad", "Teste1");
		
		ad.addInitialNode(new InitialNode("i", ad));
		ad.addFinalNode(new FinalNode("f", ad));
		
		ad.addControlFlow(new ControlFlow("c1", "i", "f", ad).setPTS(0.8));
		ad.addControlFlow(new ControlFlow("c2", "i", "f", ad).setPTS(0.2));
		
		return ad;
	}
	
	public static ActivityDiagram test4() {
		ActivityDiagram ad = new ActivityDiagram("ad", "Teste4");
		
		ad.addInitialNode(new InitialNode("i", ad));
		ad.addFinalNode(new FinalNode("f", ad));
		ad.addDecisionNode(new DecisionNode("d", ad));
		ad.addExecutableNode(new ExecutableNode("a1", ad));
		ad.addExecutableNode(new ExecutableNode("a2", ad));
		ad.addMergeNode(new MergeNode("m", ad));
		
		ad.addControlFlow(new ControlFlow("c1", "i","d",ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c2", "d", "a1", ad).setPTS(0.5));
		ad.addControlFlow(new ControlFlow("c3", "d", "a2", ad).setPTS(0.5));
		ad.addControlFlow(new ControlFlow("c4", "a1", "m", ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c5", "a2", "m", ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c6", "m", "f", ad).setPTS(1.0));
		
		return ad;
	}
	
	public static ActivityDiagram test5() {
		ActivityDiagram ad = new ActivityDiagram("ad", "Teste5");
		
		ad.addInitialNode(new InitialNode("i", ad));
		ad.addFinalNode(new FinalNode("f", ad));
		ad.addDecisionNode(new DecisionNode("d", ad));
		ad.addDecisionNode(new DecisionNode("d1", ad));
		ad.addExecutableNode(new ExecutableNode("a1", ad));
		ad.addExecutableNode(new ExecutableNode("a2", ad));
		ad.addMergeNode(new MergeNode("m", ad));
		
		ad.addControlFlow(new ControlFlow("c1", "i","d",ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c2", "d", "d1", ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c2", "d1", "a1", ad).setPTS(0.5));
		ad.addControlFlow(new ControlFlow("c3", "d1", "a2", ad).setPTS(0.5));
		ad.addControlFlow(new ControlFlow("c4", "a1", "m", ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c5", "a2", "m", ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c6", "m", "f", ad).setPTS(1.0));
		
		return ad;
	}
	
	public static ActivityDiagram test6() {
		ActivityDiagram ad = new ActivityDiagram("ad", "Teste6");
		
		ad.addInitialNode(new InitialNode("i", ad));
		ad.addFinalNode(new FinalNode("f", ad));
		ad.addDecisionNode(new DecisionNode("d", ad));
		ad.addDecisionNode(new DecisionNode("d1", ad));
		ad.addExecutableNode(new ExecutableNode("a1", ad));
		ad.addExecutableNode(new ExecutableNode("a2", ad));
		ad.addExecutableNode(new ExecutableNode("a3", ad));
		ad.addMergeNode(new MergeNode("m", ad));
		
		ad.addControlFlow(new ControlFlow("c1", "i","d",ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c2", "d", "d1", ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c2", "d1", "a1", ad).setPTS(0.5));
		ad.addControlFlow(new ControlFlow("c3", "d1", "a2", ad).setPTS(0.5));
		ad.addControlFlow(new ControlFlow("c4", "a1", "m", ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c5", "a2", "a3", ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c5", "a3", "m", ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c6", "m", "f", ad).setPTS(1.0));
		
		return ad;
	}
	
	public static ActivityDiagram test7() {
		ActivityDiagram ad = new ActivityDiagram("ad", "Teste7");
		
		ad.addInitialNode(new InitialNode("i", ad));
		ad.addFinalNode(new FinalNode("f", ad));
		ad.addDecisionNode(new DecisionNode("d", ad));
		ad.addDecisionNode(new DecisionNode("d1", ad));
		ad.addExecutableNode(new ExecutableNode("a1", ad));
		ad.addExecutableNode(new ExecutableNode("a2", ad));
		ad.addExecutableNode(new ExecutableNode("a3", ad));
		ad.addMergeNode(new MergeNode("m", ad));
		
		ad.addControlFlow(new ControlFlow("c1", "i","d",ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c2", "d", "d1", ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c2", "d1", "a1", ad).setPTS(0.4));
		ad.addControlFlow(new ControlFlow("c3", "d1", "a2", ad).setPTS(0.4));
		ad.addControlFlow(new ControlFlow("c4", "a1", "m", ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c5", "a2", "a3", ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c5", "a3", "m", ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c6", "m", "f", ad).setPTS(1.0));
		
		return ad;	
	}
	
	public static ActivityDiagram test8() {
		ActivityDiagram ad = new ActivityDiagram("ad", "Teste1");
		
		ad.addExecutableNode(new ExecutableNode("i", ad));
		ad.addExecutableNode(new ExecutableNode("f", ad));
		
		ad.addControlFlow(new ControlFlow("c1", "i", "f", ad).setPTS(1.0));
		
		return ad;
	}
	
	public static ActivityDiagram test9() {
		ActivityDiagram ad = new ActivityDiagram("ad", "Teste9");
		
		ad.addInitialNode(new InitialNode("i", ad));
		ad.addExecutableNode(new ExecutableNode("a1", ad));
		ad.addExecutableNode(new ExecutableNode("a2", ad));
		
		ad.addControlFlow(new ControlFlow("c1", "i", "a1", ad).setPTS(1.0));
		ad.addControlFlow(new ControlFlow("c2", "a1", "a2", ad).setPTS(1.0));
		
		return ad;
	}
	
	public static ActivityDiagram test10(int k) {
		ActivityDiagram ad = new ActivityDiagram("ad", "Teste10");
		
		ad.addInitialNode(new InitialNode("i", ad));
		for (int i = 0; i < k; i++) {
			ad.addExecutableNode(new ExecutableNode("a"+i, ad));
		}
		ad.addFinalNode(new FinalNode("f", ad));
		
		ad.addControlFlow(new ControlFlow("c0", "i", "a0", ad).setPTS(1.0));
		for (int i = 1; i < k; i++) {
			ad.addControlFlow(new ControlFlow("c"+i, "a"+(i-1), "a"+i, ad).setPTS(1.0));
		}
		
		ad.addControlFlow(new ControlFlow("cf", "a"+(k-1), "f", ad).setPTS(1.0));
		return ad;
	}
	
	
}
