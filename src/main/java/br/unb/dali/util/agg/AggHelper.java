package br.unb.dali.util.agg;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import agg.xt_basis.Arc;
import agg.xt_basis.BaseFactory;
import agg.xt_basis.GraGra;
import agg.xt_basis.Graph;
import agg.xt_basis.Node;
import agg.xt_basis.TypeException;

/**
 * This class provides a method repository to help deal with agg structures
 * 
 * @author abiliooliveira
 */
public final class AggHelper {
	
	/**
	 * Loads a new graph grammar from a file
	 * @param fileName
	 * @return the respective Graph Grammar
	 */
	public static GraGra loadGraGra(String resourceName) {
		if (resourceName.endsWith(".ggx")) {
			InputStream xml = Thread.currentThread().getClass().getResourceAsStream(resourceName);
	
			CustomXMLHelper h = new CustomXMLHelper();
			h.read_from_xml(xml);
	
			// create a gragra
			GraGra gra = (GraGra) h.getTopObject(BaseFactory.theFactory().createGraGra());
			return gra;
		}
		return null;
	}
	
	/**
	 * Constructs all the disconnected graphs from Agg Graph
	 * 
	 * @param g the full graph
	 * @return all disconnected sub graphs
	 * @throws TypeException 
	 */
	public static List<Graph> getStronglyConnectedComponents(Graph g) throws TypeException {
		List<Graph> toReturn = new ArrayList<Graph>();
		
		while (!g.isEmpty()) {
			Node n = (Node) g.getNodesSet().toArray()[0];
			toReturn.add(recoverConnectedGraph(n, g));
		}
		
		return toReturn;
	}

	/**
	 * Recover a connected subgraph of the Graph g, via depth first searching from a Node n
	 * 
	 * @param n the starting point node
	 * @param g the whole graph
	 * @return the connected subgraph from n
	 * @throws TypeException 
	 */
	public static Graph recoverConnectedGraph(Node n, Graph g) throws TypeException {
		Graph toReturn = new Graph(g.getTypeSet());
		toReturn.addNode(n);
		
		Iterator<Arc> incoming = n.getIncomingArcs();
		while (incoming.hasNext()) {
			Arc arc = incoming.next();
			Node source = (Node) arc.getSource();
			g.destroyNode(n);
			
			toReturn.addCopyOfGraph(recoverConnectedGraph(source, g), false);
			toReturn.addArc(arc);
		}

		Iterator<Arc> outgoing = n.getOutgoingArcs();
		while (outgoing.hasNext()) {
			Arc arc = outgoing.next();
			Node source = (Node) arc.getTarget();
			g.destroyNode(n);
			
			toReturn.addCopyOfGraph(recoverConnectedGraph(source, g), false);
			toReturn.addArc(arc);
		}
		
		return toReturn;
	}

	/**
	 * Gets all the source nodes of this incomingArcs iterator
	 * 
	 * @param incomingArcs
	 * @return an ArrayList of source nodes
	 */
	public static ArrayList<Node> getSourceNodes(Iterator<Arc> incomingArcs) {
		ArrayList<Node> toReturn = new ArrayList<Node>();
		
		while (incomingArcs.hasNext()) {
			toReturn.add((Node)incomingArcs.next().getSource());
		}
		
		return toReturn;
	}

	/**
	 * Gets all the target nodes of this outgoingArcs iterator
	 * 
	 * @param outgoingArcs
	 * @return an ArrayList of target nodes
	 */
	public static ArrayList<Node> getTargetNodes(Iterator<Arc> outgoingArcs) {
		ArrayList<Node> toReturn = new ArrayList<Node>();
		
		while (outgoingArcs.hasNext()) {
			toReturn.add((Node)outgoingArcs.next().getTarget());
		}
		
		return toReturn;
	}
	
}
