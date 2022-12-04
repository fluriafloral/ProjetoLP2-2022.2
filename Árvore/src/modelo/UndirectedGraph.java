/**
 * 
 */
package modelo;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author fluriafloral
 *
 */
public class UndirectedGraph implements Matrix {
	// attributes
	private Stack<Vertex> vertices = new Stack<Vertex>();
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private int maxConnections; // Maximum number of connections per node (house, in this case)
	private int matrixSize; // Size of matrix
	private int[][] costs; // The costs for all connections
	//methods
	public void addtoVertices(Vertex vertex) {
		vertices.push(vertex);
	}
	
	public Vertex getVertex(int id) {
		return vertices.get(id);
	}
	
	public Stack<Vertex> getVertices() {
		return vertices;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void addtoEdges(Edge edge) {
		edges.add(edge);
	}
	
	public int getMaxConnections() {
		return maxConnections;
	}
	
	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}
	
	public int getMatrixSize() {
		return matrixSize;
	}
	
	public void setMatrixSize(int matrixSize) {
		this.matrixSize = matrixSize;
	}
	
	public int[][] getCosts() {
		return costs;
	}
	
	public void setCosts(int[][] costs) {
		this.costs = costs;
	}
	
	public ArrayList<Edge> increasingCost() {
		ArrayList<Edge> sorted = new ArrayList<Edge>();
		ArrayList<Edge> ref = edges;
		Edge aux = new Edge();
		
		while (sorted.size() < edges.size()) {
			int min = ref.get(0).getCost();
			
			for (Edge e : ref) {
				if (e.getCost() < min) {
					aux = e;
					min = aux.getCost();
				}
			}
			
			sorted.add(aux);
			ref.remove(aux);
		}
		
		return sorted;
	}
}
