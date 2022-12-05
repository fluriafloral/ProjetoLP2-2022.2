/**
 * 
 */
package modelo;

import java.util.HashSet;

/**
 * Esta interface contém os atributos e métodos da matriz de entrada.
 * 
 * @author Pedro Henrique Teixeira e Silva
 * @author Gabriel Fernandes Laurindo
 * @version 1.0
 * @since 21/10/2022
 *
 */
public class SpanningTree extends Tree {
	// attributes
	private HashSet<Edge> subgraph = new HashSet<Edge>();
	private int totalCost;

	/**
	 * Adiciona a aresta recebida em subgraph e aumenta o valor de totalCost
	 * 
	 * @param edge - aresta a ser adicionada
	 */
	@Override
	public void addtoTree(Edge edge) {
		this.subgraph.add(edge);
		this.totalCost += edge.getCost();
	}
	
	@Override
	public int getTotalCost() {
		return this.totalCost;
	}
	
	@Override
	public HashSet<Edge> getSubgraph() {
		return subgraph;
	}
}
