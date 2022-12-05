/**
 * 
 */
package modelo;

/**
 * Esta classe representa as arestas da árvore.
 * 
 * @author Pedro Henrique Teixeira e Silva
 * @author Gabriel Fernandes Laurindo
 * @version 2.0
 * @since 23/11/2022
 *
 */
public class Edge {
	// attributes
	private Vertex a; 
	private Vertex b; // vértices que fazem parte da aresta 
	private int cost; // custo associado a esta determinada conexão
	// methods
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public void setEdges(Vertex a, Vertex b) {
		this.a = a;
		this.b = b;
	}
	
	public Vertex[] getNodes() {
		Vertex[] pair = {this.a, this.b};
		return pair;
	}
}
