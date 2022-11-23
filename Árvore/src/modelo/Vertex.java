/**
 * 
 */
package modelo;

/**
 * Esta classe representa o vértice (ou nodo) da árvore.
 * 
 * @author Pedro Henrique Teixeira e Silva
 * @author Gabriel Fernandes Laurindo
 * @version 1.0
 * @since 23/11/2022
 *
 */

public class Vertex {
	// attributes
	private int[] connections;
	// methods
	public Vertex(int[] costs) {
		this.connections = costs;
	}
	
	public int getMinimalCost() {
		int min = this.connections[0];
		
		for (int i : this.connections) {
			if (i < min) {
				min = i;
			}
		}
		
		return min;
	}
}
