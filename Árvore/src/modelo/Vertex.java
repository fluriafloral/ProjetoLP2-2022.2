/**
 * 
 */
package modelo;

/**
 * Esta classe representa os vértices da árvore.
 * 
 * @author Pedro Henrique Teixeira e Silva
 * @author Gabriel Fernandes Laurindo
 * @version 2.0
 * @since 23/11/2022
 *
 */
public class Vertex {
	// attributes
	private int id; // identifica-se cada vértice com um inteiro variando entre 0 e MatrixSize - 1
	// methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
