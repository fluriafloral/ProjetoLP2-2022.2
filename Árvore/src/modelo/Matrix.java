package modelo;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Esta interface contém os métodos da matriz de entrada, que são implementados em UndirectedGraph.
 * 
 * @author Pedro Henrique Teixeira e Silva
 * @author Gabriel Fernandes Laurindo
 * @version 1.0
 * @since 21/10/2022
 *
 */
interface Matrix {
	void addtoVertices(Vertex vertex);
	Vertex getVertex(int id);
	Stack<Vertex> getVertices();
	ArrayList<Edge> getEdges();
	void addtoEdges(Edge edge);
	int getMaxConnections();
	void setMaxConnections(int maxConnections);
	int getMatrixSize();
	void setMatrixSize(int matrixSize);
}
