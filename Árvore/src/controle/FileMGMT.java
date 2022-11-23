package controle;

import java.io.File;
import java.util.Scanner;

import modelo.Matrix;

public class FileMGMT {
	// methods
	public Matrix initialize(String filepath) {
		Matrix m = new Matrix();
		try {
			File entry = new File(filepath);
			Scanner scan = new Scanner(entry);
			
			m.setMatrixSize(scan.nextInt());
			m.setMaxConnections(scan.nextInt());
			
			int[][] values = new int[m.getMatrixSize()][m.getMatrixSize()];
			for (int i = 0; i < m.getMatrixSize(); i++) {
				for (int j = i; j < m.getMatrixSize(); j++) {
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
			
			m.setMatrix(values);
			
			scan.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return m;
	}
}
