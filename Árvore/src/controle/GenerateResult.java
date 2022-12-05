package controle;

import java.util.ArrayList;

import modelo.*;;

/**
 * Esta classe imprime os resultados gerados
 * 
 * @author Pedro Henrique Teixeira e Silva
 * @author Gabriel Fernandes Laurindo
 * @version 2.0
 * @since 28/11/2022
 *
 */
public class GenerateResult {
	/**
	 * Imprime as Spanning Trees válidas e em seguida a de menor custo total
	 * 
	 * @param validTrees
	 */
	public void printResult(ArrayList<SpanningTree> validTrees) {
		System.out.println("Spanning Trees válidas geradas pelo programa: ");
		int minCost = validTrees.get(0).getTotalCost();
		SpanningTree mst = new SpanningTree();
		
		for (SpanningTree st : validTrees) {
			for (Edge e : st.getSubgraph()) {
				System.out.print(e.getNodes()[0].getId() + "->" + e.getNodes()[1].getId() + " ");
			}
			System.out.println(" / Custo total: " + st.getTotalCost());
			
			if (st.getTotalCost() < minCost) {
				
				minCost = st.getTotalCost();
				mst = st;
			}
		}
		
		System.out.println("############################################");
		System.out.println("das " + validTrees.size() + " spanning trees válidas, a de menor custo total (MST) é :");
		for (Edge e : mst.getSubgraph()) {
			System.out.print(e.getNodes()[0].getId() + "->" + e.getNodes()[1].getId() + " ");
		}
		System.out.println(" / Custo total: " + mst.getTotalCost());
	}
}
