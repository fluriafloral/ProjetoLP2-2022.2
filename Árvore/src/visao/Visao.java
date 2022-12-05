package visao;

import controle.*;
import modelo.*;

public class Visao {
	public static void main(String[] args) {
		FileMGMT f = new FileMGMT();
		UndirectedGraph ug = f.initialize("../Árvore/entradas/simples.txt");
		
		TreeProcessing tp = new TreeProcessing();
		GenerateResult gr = new GenerateResult();
		gr.printResult(tp.baseline(ug));
	}

}
