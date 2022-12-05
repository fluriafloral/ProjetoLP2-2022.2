/**
 * 
 */
package modelo;

import java.util.HashSet;

/**
 * Esta classe abstrata contém os métodos abstratos da árvore de custo, que será utilizada por SpanningTree.
 * 
 * @author Pedro Henrique Teixeira e Silva
 * @author Gabriel Fernandes Laurindo
 * @version 1.0
 * @since 21/10/2022
 *
 */
public abstract class Tree {
	// methods 
	public abstract void addtoTree(Edge edge);
	public abstract int getTotalCost();
	public abstract HashSet<Edge> getSubgraph();
}
