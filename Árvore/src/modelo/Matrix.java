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

interface Matrix {
	int getMatrixSize();
	void setMatrixSize(int matrixSize);
	int[][] getCosts();
	void setCosts(int[][] costs);
}
