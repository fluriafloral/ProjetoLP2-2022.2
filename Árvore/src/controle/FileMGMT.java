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
				Vertex vect = new Vertex();
				vect.setId(i);
				vect.setConnections(ug.getMaxConnections());
				ug.addtoVertices(vect);
			}
			
			int[][] values = new int[ug.getMatrixSize()][ug.getMatrixSize()];
			for (int i = 0; i < ug.getMatrixSize(); i++) {
				for (int j = i; j < ug.getMatrixSize(); j++) {
					if (i != j) {
						int v = scan.nextInt();
						
						values[i][j] = v;
						values[j][i] = v;
					}
					else {
						values[i][j] = -1;
					}
				}
			}
			
			for (int i = 0; i < ug.getMatrixSize(); i++) {
				for (int j = 0; j < ug.getMatrixSize(); j++) {
					if (i != j) {
						Edge edge = new Edge();
						
						Vertex a = ug.getVertex(i);
						Vertex b = ug.getVertex(j);
						
						edge.setEdges(a, b);
						edge.setCost(values[i][j]);
						
						ug.addtoEdges(edge);
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
