package unbdali;

import br.unb.dali.models.agg.exceptions.AggModelConstructionException;
import br.unb.dali.models.agg.uml.SequenceDiagram;
import br.unb.dali.models.agg.uml.sd.Lifeline;

public class TestSD2DTMC {
	
	public static void main (String[] args) {
		try {
			
			int k = 10;  
			double[] results = new double[k];
			String result = "";
			
			for (int i = 0; i<k; i++) {
				long start = System.currentTimeMillis();
//				result = test1().toDTMC().toPRISM().toString(); // OK
//				result = test2().toDTMC().toPRISM().toString(); // OK
//				result = test3().toDTMC().toPRISM().toString(); // OK
//				result = test4().toDTMC().toPRISM().toString(); // OK
//				result = test5().toDTMC().toPRISM().toString(); // ERR - OK
				result = test6().toDTMC().toPRISM().toString(); // OK
//				result = test7().toDTMC().toPRISM().toString(); // OK
//				result = test8(100).toDTMC().toPRISM().toString(); // OK
				results[i] = (double)System.currentTimeMillis() - start;
			}
			
			Statistics stats = new Statistics(results);
			System.out.println("Model:\n\n" + result);
			System.out.println("--------------------");
			System.out.println("Statistics:\n Mean: " + stats.getMean() + "ms StdDeviation:" + stats.getStdDev() + "ms");
		} catch (AggModelConstructionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SequenceDiagram test1() {
		SequenceDiagram sd = new SequenceDiagram("sd","Teste1");
		
		sd.addLifeline(new Lifeline("l1", "A", sd).setBCompRel(1.0));
		
		return sd;
	}
	
	public static SequenceDiagram test2() {
		SequenceDiagram sd = new SequenceDiagram("sd","Teste2");
		
		sd.addLifeline(new Lifeline("l1", "A", sd).setBCompRel(1.0));
		sd.addLifeline(new Lifeline("l2", "B", sd).setBCompRel(0.9));
		
		return sd;
	}
	
	public static SequenceDiagram test3() {
		SequenceDiagram sd = new SequenceDiagram("sd","Teste3");
		
		sd.addLifeline(new Lifeline("l1", "A", sd).setBCompRel(1.0));
		sd.addLifeline(new Lifeline("l2", "B", sd).setBCompRel(0.9));
		sd.addAsyncMessage("m1", "l1", "l2", "hw()");
		
		return sd;
	}
	
	public static SequenceDiagram test4() {
		SequenceDiagram sd = new SequenceDiagram("sd","Teste4");
		
		sd.addLifeline(new Lifeline("l1", "A", sd).setBCompRel(1.0));
		sd.addLifeline(new Lifeline("l2", "B", sd).setBCompRel(0.9));
		sd.addAsyncMessage("m1", "l1", "l2", "hw()");
		sd.addAsyncMessage("m2", "l2", "l1", "hw()");
		
		return sd;
	}

	public static SequenceDiagram test5() {
		SequenceDiagram sd = new SequenceDiagram("sd","Teste5");
		
		sd.addLifeline(new Lifeline("l1", "A", sd).setBCompRel(1.0));
		sd.addLifeline(new Lifeline("l2", "B", sd));
		sd.addAsyncMessage("m1", "l1", "l1", "hw()");
		
		return sd;
	}
	
	public static SequenceDiagram test6() {
		SequenceDiagram sd = new SequenceDiagram("sd","Test6");
		
		sd.addLifeline(new Lifeline("l1", "A", sd).setBCompRel(0.9));
		sd.addLifeline(new Lifeline("l2", "B", sd).setBCompRel(0.8));
		sd.addAsyncMessage("m1", "l1", "l1", "hw()");
		
		return sd;
	}
	
	public static SequenceDiagram test7() {
		SequenceDiagram sd = new SequenceDiagram("sd","Teste7");
		
		sd.addLifeline(new Lifeline("l1", "A", sd).setBCompRel(0.9));
		sd.addLifeline(new Lifeline("l2", "B", sd).setBCompRel(0.8));
		sd.addLifeline(new Lifeline("l3", "C", sd).setBCompRel(0.8));
		
		sd.addAsyncMessage("m1", "l1", "l1", "hw()");
		sd.addAsyncMessage("m2", "l2", "l3", "h");
		sd.addAsyncMessage("m3", "l3", "l2", "r");
		sd.addAsyncMessage("m3", "l2", "l1", "rh");
		
		return sd;
	}
	
	public static SequenceDiagram test8(int k){
		SequenceDiagram sd = new SequenceDiagram("sd","Teste8");
		
		sd.addLifeline(new Lifeline("l1", "A", sd).setBCompRel(0.9));
		sd.addLifeline(new Lifeline("l2", "B", sd).setBCompRel(0.8));
		
		for (int i = 0; i < k/2; i+=2) {
			sd.addAsyncMessage("m"+i, "l1", "l2", "m"+i);
			sd.addAsyncMessage("m"+(i+1), "l2", "l1", "m"+(i+1));
		}
		
		return sd;
	}
}
