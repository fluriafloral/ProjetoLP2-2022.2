package controle;

import java.util.ArrayList;
import java.util.Stack;

import modelo.*;

public class TreeProcessing {
	int counter = 0;
	ArrayList<SpanningTree> validTrees = new ArrayList<SpanningTree>();
	// methods
	public boolean validSpanningTree(UndirectedGraph ug, Edge[] edgesSubset) {
		boolean valid = false;
		Stack<Vertex> v = new Stack<Vertex>();
		Stack<Vertex> checkCircuit = new Stack<Vertex>();
		
		for (Vertex vert : ug.getVertices()) {
			v.add(vert);
		}
		
		int[] connectionsLeft = new int[ug.getMatrixSize()];
		for (int i = 0; i < connectionsLeft.length; i++) {
			connectionsLeft[i] = ug.getMaxConnections();
		}
		
		Edge[] aux = new Edge[edgesSubset.length];
		System.arraycopy(edgesSubset, 0, aux, 0, edgesSubset.length);
		
		for (Edge e : aux) {
			Vertex[] vert = e.getNodes();
			
			v.remove(ug.getVertex(vert[0].getId()));
			connectionsLeft[vert[0].getId()] -= 1;
			
			v.remove(ug.getVertex(vert[1].getId()));
			connectionsLeft[vert[1].getId()] -= 1;
			checkCircuit.add(vert[1]);
			
			if (checkCircuit.contains(vert[0]) && checkCircuit.contains(vert[1])) {
				return false;
			}
		}
		
		for (int i : connectionsLeft) {
			if (i < 0) {
				return false;
			}
		}
		
		if (v.isEmpty()) {
			valid = true;
		}
		
		return valid;
	}
	
	public void combination(UndirectedGraph ug, Edge[] aux, int begin, int index) {
		ArrayList<Edge> edges = ug.getEdges();
		int end = ug.getEdges().size() - 1;
		int size = ug.getMatrixSize() - 1;
		
		if (index == size) {
			if (validSpanningTree(ug, aux)) {
				SpanningTree st = new SpanningTree();
				
				st.setMaxSize(size);
				for (Edge e : aux) {
					st.addtoTree(e);
					System.out.print(e.getNodes()[0].getId() + "->" + e.getNodes()[1].getId() + " ");
				}
				
				System.out.println("= " + st.getTotalCost());
				
				validTrees.add(st);
				counter++;
			}
			
			return;
		}
		
		for (int i = begin; i <= end && (end - i + 1) >= size - index; i++) {
			aux[index] = edges.get(i);
			combination(ug, aux, i+1, index+1);
		}
	}
	
	public void printcomb(UndirectedGraph ug) {
		Edge[] data = new Edge[ug.getMatrixSize()-1];
		combination(ug, data, 0, 0);
		System.out.println(counter);
	}
	
	public ArrayList<SpanningTree> baseline(UndirectedGraph ug) {
		int listSize = (int) Math.pow(ug.getMatrixSize(), ug.getMatrixSize() - 2);
		
		for (int i = 0; i < listSize; i++) {
			SpanningTree st = new SpanningTree();
			
			for (int j = 0; j < ug.getMatrixSize() - 1; j++) {
				
			}
		}
		
		return validTrees;
	}
	
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
							//edges[0].decreaseCon();
						}
					}
					if (v.contains(edges[1])) {
						if (edges[1].getConnections() > 0) {
							mst.addtoTree(e);
							v.remove(edges[1]);
							//edges[1].decreaseCon();
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
