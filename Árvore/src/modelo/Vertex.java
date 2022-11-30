/**
 * 
 */
package modelo;

/**
 * @author fluriafloral
 *
 */
public class Vertex {
	// attributes
	private int id;
	private int connections;
	// methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getConnections() {
		return connections;
	}

	public void setConnections(int connections) {
		this.connections = connections;
	}
	
	public void decreaseCon() {
		this.connections--;
	}
}
