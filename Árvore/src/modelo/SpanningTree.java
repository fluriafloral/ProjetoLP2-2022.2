/**
 * 
 */
package modelo;

import java.util.HashSet;

/**
 * @author fluriafloral
 *
 */
public class SpanningTree extends Tree{
	// attributes
	private int maxSize;
	private HashSet<Edge> subgraph = new HashSet<Edge>();
	private int totalCost;
	// methods 
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}


	@Override
	public void addtoTree(Edge edge) {
		// TODO Auto-generated method stub
		
	}

}
