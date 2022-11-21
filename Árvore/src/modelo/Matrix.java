package modelo;

/**
 * Esta classe contém os atributos e métodos da matriz de entrada.
 * 
 * @author Pedro Henrique Teixeira e Silva
 * @author Gabriel Fernandes Laurindo
 * @version 1.0
 * @since 21/10/2022
 *
 */

public class Matrix {
	// attributes
	private int matrixSize; // tamanho da matriz quadrada
	private int maxConnections; // número máximo de conexões por casa
	private int[][] matrix; // matriz processada no arquivo 
	// methods
	public int getMatrixSize() {
		return matrixSize;
	}
	public void setMatrixSize(int matrixSize) {
		this.matrixSize = matrixSize;
	}
	public int getMaxConnections() {
		return maxConnections;
	}
	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}
	public int[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	 
}
