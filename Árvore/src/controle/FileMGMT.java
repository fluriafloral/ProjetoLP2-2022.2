package controle;

import java.io.File;
import java.util.Scanner;

import modelo.*;

public class FileMGMT {
	// methods
	public UndirectedGraph initialize(String filepath) {
		UndirectedGraph ug = new UndirectedGraph();
		try {
			File entry = new File(filepath);
			Scanner scan = new Scanner(entry);
			
			ug.setMatrixSize(scan.nextInt());
			ug.setMaxConnections(scan.nextInt());
			
			for (int i = 0; i < ug.getMatrixSize(); i++) {
				Vertex vert = new Vertex();
				vert.setId(i);
				ug.addtoVertices(vert);
			}
			
			int[][] values = new int[ug.getMatrixSize()][ug.getMatrixSize()];
			for (int i = 0; i < ug.getMatrixSize(); i++) {
				for (int j = i; j < ug.getMatrixSize(); j++) {
					if (i != j) {
						int v = scan.nextInt();
						
						Edge edge = new Edge();
						
						Vertex a = ug.getVertex(i);
						Vertex b = ug.getVertex(j);
						
						edge.setEdges(a, b);
						edge.setCost(v);
						
						ug.addtoEdges(edge);
						
						values[i][j] = v;
						values[j][i] = v;
					}
					else {
						values[i][j] = -1;
					}
				}
			}
			
			ug.setCosts(values);
			
			scan.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return ug;
	}
}
