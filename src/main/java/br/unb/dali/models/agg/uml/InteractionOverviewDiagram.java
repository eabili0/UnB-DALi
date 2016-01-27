package br.unb.dali.models.agg.uml;

import java.util.ArrayList;
import java.util.List;

import br.unb.dali.models.IModel;
import br.unb.dali.models.agg.markovchains.CompositeDTMC;
import br.unb.dali.models.agg.markovchains.MultiDTMC;
import br.unb.dali.models.agg.uml.ad.edges.ControlFlow;
import br.unb.dali.models.agg.uml.ad.nodes.control.DecisionNode;
import br.unb.dali.models.agg.uml.ad.nodes.control.FinalNode;
import br.unb.dali.models.agg.uml.ad.nodes.control.InitialNode;
import br.unb.dali.models.agg.uml.ad.nodes.control.MergeNode;
import br.unb.dali.models.agg.uml.ad.nodes.executable.ExecutableNode;

/**
 * Instancies of this Class represents UML 2.5 Interaction Overview Diagrams (IOD)
 * IODs provides an overview of the control flow of a system, by being an activity diagram where
 * the executable nodes represent scenarios in the form of Sequence Diagrams. 
 * 
 * @author abiliooliveira
 */
public class InteractionOverviewDiagram implements IModel {
	private ActivityDiagram _control;
	private List<SequenceDiagram> _scenarios;
	private String _name;
	private String _id;
	
	/***************************** CONSTRUCTOR *******************************/
	public InteractionOverviewDiagram(String id, String name) {
		_name = name;
		_id = id;
		_scenarios = new ArrayList<SequenceDiagram>();
		_control = new ActivityDiagram(_id, _name.replace(' ', '_')+"_Control");
	}
	
	/***************************** PUBLIC BEHAVIOR *******************************/
	
	/**
	 * Adds a new control flow between nodes of this InteractionOverviewDiagram
	 * @param controlFlowId the string identifier of this ControlFlow object
	 * @param sourceId the string identifier of the source node
	 * @param targetId the string identifier of the target node
	 * @return the added control flow
	 */
	public ControlFlow addControlFlow(String controlFlowId, String sourceId, String targetId, double PTS) {
		ControlFlow cf = new ControlFlow(controlFlowId, sourceId, targetId, _control);
		cf.setPTS(PTS);
		_control.addControlFlow(cf);
		return cf;
	}
	
	/**
	 * Adds a new initial node to this UML 2.5 IOD
	 * @param id the string identifier of the InitialNode to be added
	 * @param label string to label this node
	 * @return the added initial node
	 */
	public InitialNode addInitialNode(String id, String label) {
		InitialNode initialNode = new InitialNode(id, _control);
		initialNode.setLabel(label);
		_control.addInitialNode(new InitialNode(id, _control));
		return initialNode;
	}
	
	/**
	 * Adds a new Final Node to this UML 2.5 IOD
	 * @param id the string identifier of the FinalNode to be added
	 * @param label string to label this node 
	 * @return the added final node
	 */
	public FinalNode addFinalNode(String id, String label) {
		FinalNode finalNode = new FinalNode(id, _control);
		finalNode.setLabel(label);
		_control.addFinalNode(finalNode);
		return finalNode;
	}

	/**
	 * Adds a new DecisionNode to this UML 2.5 IOD
	 * @param id the string identifier of the DecisionNode to be added
	 * @param label string to label this node
	 * @return the added decision node
	 */
	public DecisionNode addDecisionNode(String id, String label) {
		DecisionNode decisionNode = new DecisionNode(id, _control);
		decisionNode.setLabel(label);
		_control.addDecisionNode(decisionNode);
		return decisionNode;
	}
	
	/**
	 * Adds a new MergeNode to this UML 2.5 IOD
	 * 
	 * @param id the string identifier of the MergeNode to be added
	 * @param label string to label this node
	 * @return the added merge node
	 */
	public MergeNode addMergeNode(String id, String label) {
		MergeNode mergeNode = new MergeNode(id, _control);
		mergeNode.setLabel(label);
		_control.addMergeNode(mergeNode);
		return mergeNode;
	}
	
	/**
	 * Adds a new Interaction Use to the UML 2.5 IOD
	 * 
	 * @param id the string identifier of this Interaction Use (not necessarily equals to the SD id)
	 * @param sd the UML 2.5 scenario use to be added
	 * @param label string to label this interaction use
	 * 
	 * @return the added scenario use
	 */
	public SequenceDiagram addInteractionUse(String id, SequenceDiagram sd, String label) {
		ExecutableNode ref = new ExecutableNode(id, _control);
		ref.setLabel(label);
		_control.addExecutableNode(ref);
		_scenarios.add(sd);
		return sd;
	}
	
	/**
	 * The DTMC representation of this UML 2.5 Interaction Overview Diagram
	 * @return
	 */
	public CompositeDTMC toDTMC() {
		CompositeDTMC toReturn = new CompositeDTMC();
		toReturn.addMultiDTMC(new MultiDTMC(_control.toDTMC()));
		for (SequenceDiagram sd : _scenarios) {
			toReturn.addMultiDTMC(sd.toDTMC());
		}
		return toReturn;
	}
	
	/***************************** INHERITANCE *******************************/
	@Override
	public void checkModel() {
		_control.checkModel();
		for (SequenceDiagram sd : _scenarios) {
			sd.checkModel();
		}
	}
}
