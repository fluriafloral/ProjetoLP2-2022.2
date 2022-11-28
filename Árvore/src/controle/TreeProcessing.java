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
		
		for ()
		
		return mst;
	}
}
