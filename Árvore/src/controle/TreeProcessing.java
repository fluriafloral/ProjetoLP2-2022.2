package controle;

import java.util.ArrayList;
import java.util.Stack;

import modelo.*;

public class TreeProcessing {
	// methods
	public SpanningTree calculateMST(UndirectedGraph ug) {
		SpanningTree mst = new SpanningTree();
		
		mst.setMaxSize(ug.getMatrixSize() - 1);
		Stack<Vertex> v = ug.getVertices();
		ArrayList<Edge> ic = ug.increasingCost();
		
		for (Edge e : ic) {
			if (!v.isEmpty()) {
				Vertex[] edges = e.getNodes();
				if (v.contains(edges[0]) || v.contains(edges[1])) {
					if (v.contains(edges[0])) {
						if (edges[0].getConnections() > 0) {
							mst.addtoTree(e);
							v.remove(edges[0]);
							edges[0].decreaseCon();
						}
					}
					if (v.contains(edges[1])) {
						if (edges[1].getConnections() > 0) {
							mst.addtoTree(e);
							v.remove(edges[1]);
							edges[1].decreaseCon();
						}
					}
				}
			}
			else {
				break;
			}
		}
		
		return mst;
	}
	
	public SpanningTree[] kruskal(UndirectedGraph ug) {
		SpanningTree[] st = new SpanningTree[2];
		
		return st;
	}
}
