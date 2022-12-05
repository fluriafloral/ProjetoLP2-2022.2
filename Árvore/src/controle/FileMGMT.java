package controle;

import java.io.File;
import java.util.Scanner;

import modelo.*;

/**
 * Esta classe é responsável pelo processamento do arquivo de entrada
 * 
 * @author Pedro Henrique Teixeira e Silva
 * @author Gabriel Fernandes Laurindo
 * @version 2.0
 * @since 23/11/2022
 *
 */
public class FileMGMT {
	/**
	 * Lê o arquivo de entrada e gera um objeto do tipo Undirected Graph com a informação processada.
	 * 
	 * @param filepath - localização do arquivo no sistema
	 * @return ug - Undirected Graph com as informações lidas
	 */
	public UndirectedGraph initialize(String filepath) {
		UndirectedGraph ug = new UndirectedGraph();
		// tratamento de exceção para caso não seja encontrado o arquivo passado
		try {
			File entry = new File(filepath);
			Scanner scan = new Scanner(entry);
			// define o tamanho da matriz e número máximo de conexões
			ug.setMatrixSize(scan.nextInt());
			ug.setMaxConnections(scan.nextInt());
			// instancia MatrixSize objetos do tipo Vertex, uma identidade (nesse caso, um número inteiro) para cada um
			for (int i = 0; i < ug.getMatrixSize(); i++) {
				Vertex vert = new Vertex();
				vert.setId(i);
				ug.addtoVertices(vert);
			}
			
			for (int i = 0; i < ug.getMatrixSize(); i++) {
				for (int j = i; j < ug.getMatrixSize(); j++) {
					if (i != j) {
						int v = scan.nextInt();
						// para cada custo lido em arquivo, cria um objeto do tipo Edge
						Edge edge = new Edge();
						// define os vértices associados aquela aresta
						Vertex a = ug.getVertex(i);
						Vertex b = ug.getVertex(j);
						// os armazena junto com o custo
						edge.setEdges(a, b);
						edge.setCost(v);
						// adiciona o objeto criado a array Edges
						ug.addtoEdges(edge);
					}
				}
			}
			
			scan.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return ug;
	}
}
