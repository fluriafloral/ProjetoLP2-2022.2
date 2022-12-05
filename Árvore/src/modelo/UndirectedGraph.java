/**
 * 
 */
package modelo;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Esta classe representa o grafo processado a partir do aquivo de entrada, implementando a interface Matrix.
 * 
 * @author Pedro Henrique Teixeira e Silva
 * @author Gabriel Fernandes Laurindo
 * @version 1.0
 * @since 21/10/2022
 *
 */
public class UndirectedGraph implements Matrix {
	// attributes
	private Stack<Vertex> vertices = new Stack<Vertex>();
	private ArrayList<Edge> edges = new ArrayList<Edge>(); 
	private int maxConnections; // Numero máximo de conexões que podem estar associados a um vértice (casa)
	private int matrixSize; // Quantidade de vértices
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
}
