package controle;

import java.util.ArrayList;
import java.util.Stack;

import modelo.*;

/**
 * Esta classe processa o grafo definido e gera as spanning trees
 * 
 * @author Pedro Henrique Teixeira e Silva
 * @author Gabriel Fernandes Laurindo
 * @version 2.0
 * @since 23/11/2022
 *
 */
public class TreeProcessing {
	// attributes
	ArrayList<SpanningTree> validTrees = new ArrayList<SpanningTree>();
	// methods
	/**
	 * Verifica se o subconjunto de Edges passado por parâmetro é uma Spanning Tree válida 
	 * (inclui todos os vértices, não forma circuitos e respeita o número máximo de conexões definidos)
	 * 
	 * @param ug - grafo completo
	 * @param edgesSubset - subconjunto de Edges
	 * @return true caso seja válida, caso contrário retorna false
	 */
	public boolean validSpanningTree(UndirectedGraph ug, Edge[] edgesSubset) {
		boolean valid = false;
		// duas stacks de vértices: uma serve para checar se todos os vértices estão sendo conectados por edgesSubset
		Stack<Vertex> v = new Stack<Vertex>();
		// a outra para verificar se há formação de circuitos
		Stack<Vertex> checkCircuit = new Stack<Vertex>();
		// adiciona todos os vértices existentes em v
		for (Vertex vert : ug.getVertices()) {
			v.add(vert);
		}
		// vetor de inteiros para contar quantas conexões ainda são possíveis de fazer com cada casa
		int[] connectionsLeft = new int[ug.getMatrixSize()];
		for (int i = 0; i < connectionsLeft.length; i++) {
			connectionsLeft[i] = ug.getMaxConnections();
		}
		// faz uma cópia de edgesSubset para não alterar o objeto original
		Edge[] aux = new Edge[edgesSubset.length];
		System.arraycopy(edgesSubset, 0, aux, 0, edgesSubset.length);
	
		for (Edge e : aux) {
			Vertex[] vert = e.getNodes();
			// remove de v os vértices associados ao Edge atual e decrementa a quantidade de conexões possíveis
			v.remove(ug.getVertex(vert[0].getId()));
			connectionsLeft[vert[0].getId()] -= 1;
			
			v.remove(ug.getVertex(vert[1].getId()));
			connectionsLeft[vert[1].getId()] -= 1;
			// adiciona o segundo vértice dessa aresta em checkCircuit
			checkCircuit.add(vert[1]);
			// se os dois vértices dessa aresta já estiverem em checkCircuit é porque foi formado um circuito
			if (checkCircuit.contains(vert[0]) && checkCircuit.contains(vert[1])) {
				return false;
			}
		}
		// checa se algum dos nodos ultrapassou a quantidade máxima de conexões
		for (int i : connectionsLeft) {
			if (i < 0) {
				return false;
			}
		}
		// se não tiver retornado falso até aqui é porque não tem circuito formado e está respeitando a quantidade máxima de conexões
		// se v estiver vazio é porque todos os vértices do grapho estão conectados, logo, é uma spanning tree válida
		if (v.isEmpty()) {
			valid = true;
		}
		
		return valid;
	}
	
	/**
	 * Função recursiva para gerar todas combinações de tamanho (MatrixSize - 1) das arestas do grafo
	 * 
	 * @param ug - grafo completo
	 * @param aux - vetor auxiliar para armazenar temporariamente o subconjunto de Edges
	 * @param begin - índice apontando para o primeiro elemento de aux
	 * @param index - índice apontando para o elemento atual de aux
	 */
	public void combination(UndirectedGraph ug, Edge[] aux, int begin, int index) {
		ArrayList<Edge> edges = ug.getEdges();
		int end = ug.getEdges().size() - 1;
		int size = ug.getMatrixSize() - 1;
		// a função é chamada de forma recursiva até index ser igual MatrixSize - 1
		if (index == size) {
			// se a combinação gerada não for uma spanning tree válida, ela é ignorada
			if (validSpanningTree(ug, aux)) {
				SpanningTree st = new SpanningTree();
				// instancia um objeto do tipo SpanningTree e define as arestas que fazem parte
				for (Edge e : aux) {
					st.addtoTree(e);
				}
				// adiciona st na lista de árvores válidas
				validTrees.add(st);
			}
			return;
		}
		// se não cai no if, vem para este laço onde adiciona cada elemento de Edges na posição index de aux
		// e realiza a chamada recursiva de combination incrementando begin e index em uma unidade
		// a condição (end-i+1) >= size-index garante que ao inserir um elemento na posição index, ele formará uma combinação com os elementos nas posições restantes
		for (int i = begin; i <= end && (end - i + 1) >= size - index; i++) {
			aux[index] = edges.get(i);
			combination(ug, aux, i+1, index+1);
		}
	}
	
	/**
	 * Gera todas as combinações possíveis de arestas e retorna uma array contendo as que formam uma spanning tree válida
	 * 
	 * @param ug - grafo completo
	 * @return validTrees - array contendo todos os subconjuntos de Edges que formam spanning trees válidas
	 */
	public ArrayList<SpanningTree> baseline(UndirectedGraph ug) {
		Edge[] data = new Edge[ug.getMatrixSize()-1];
		combination(ug, data, 0, 0);
		
		return validTrees;
	}
}
