package schuljahr2;

import java.util.Arrays;

public class GleichungsSysteme {

	public static void main(String[] args) {
		/*
		 * koeffizientenMatrix = [[1,2]  und b = [5, 6] entspricht dem Gleichungssystem:
		 * 						  [3,4]] 
		 * 
		 *  1*x1 + 2*x2 = 5
		 *  3*x1 + 4*x2 = 6
		 */
		
		double[][] koeffizientenMatrix = {{ 0,  1, 2},
										  { 0,  1, -1},
										  { 0,  2,  1}};
		double[] b = {5, -1, 4};
		
		double[] solution = gleichungssystemSolver(koeffizientenMatrix, b);
		System.out.println("\n[x1, x2, ..., (1,0,-1)] 1 = Eindeutig, 0 = keine lösung, -1 = mehrere Lösungen");
		System.out.println("Lösung: " + Arrays.toString(solution));
		
	}
	
	/*
	Aufgabe 9: Gauß-Rechner
	Schreiben Sie eine Methode, die ein lineares Gleichungssystem in Form einer zweidimensionalen
	Koeffizientenmatrix (Größe n x n) übergeben bekommt. Die Methode soll ein eindimensionales Array der
	Größe n+1 zurückgeben. Dabei sind die ersten n Werte die Lösungswerte der n-elementigen
	Lösungsmenge und der n+1-te Wert ein Indikator ob das Gleichungssystem ein-, mehr- oder unlösbar ist.
	*/
	
	public static double[] gleichungssystemSolver(double[][] koeffizientenMatrix, double[] b) {
		
		if(koeffizientenMatrix.length != koeffizientenMatrix[0].length || b.length != koeffizientenMatrix.length) {
			System.out.println("Dimension mismatch!");
			return null;
		}
		
		double[][] augmentedMatrix = makeAugmentedMatrix(koeffizientenMatrix, b);
		System.out.println("Augmented Matrix:");
		printMatrix(augmentedMatrix);
		
		double[] solution = gaussElimination(augmentedMatrix);
		return solution;
	}
	
	public static void printMatrix(double[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	
	public static double[][] makeAugmentedMatrix(double[][] koeffizientenMatrix, double[] b) {
		double[][] augmentedMatrix = new double[koeffizientenMatrix.length][koeffizientenMatrix.length+1];
		
		for(int i=0; i<koeffizientenMatrix.length; i++) {
			for(int j=0; j<koeffizientenMatrix[i].length; j++) {
				augmentedMatrix[i][j] = koeffizientenMatrix[i][j];
			}
		}
		for(int i=0; i<augmentedMatrix.length; i++) {
			augmentedMatrix[i][koeffizientenMatrix.length] = b[i];
		}
		return augmentedMatrix;
	}
	 
	public static double[] gaussElimination(double[][] augmentedMatrix) {
		// https://en.wikipedia.org/wiki/Gaussian_elimination
		double[] solution = new double[augmentedMatrix.length + 1];
		// dimension des Gleichungssystems
		int dim = augmentedMatrix.length;
		
		// turn matrix into echelon form (also called triangular form) 
		for(int col=0; col<dim-1; col++) {
			/*
			 * swap rows to prevent divison by 0
			 */
			int firstNonZeroRowIndex = -1;
			for(int i=col; i<dim; i++) {
				if(augmentedMatrix[i][col] != 0) {
					firstNonZeroRowIndex = i;
					break;
				}
			}
			if(firstNonZeroRowIndex == -1) {
				continue;
			}else {
				augmentedMatrix = swapMartixRows(augmentedMatrix, col, firstNonZeroRowIndex);
			}
			System.out.println("after swaping rows: ");
			printMatrix(augmentedMatrix);
			/*
			 * end: swap rows to prevent divison by 0
			 */
			
			for(int k=col+1; k<dim; k++) {
				double factor = augmentedMatrix[k][col]/augmentedMatrix[col][col];
				
				for(int j=0; j<augmentedMatrix[k].length; j++) {
					augmentedMatrix[k][j] = augmentedMatrix[k][j] - augmentedMatrix[col][j]*factor;
				}
			}
			System.out.println("after elimination: ");
			printMatrix(augmentedMatrix);
		}
		System.out.println("row echelon form: ");
		printMatrix(augmentedMatrix);
		
		/*
		- Swapping two rows multiplies the determinant by -1
    	- Multiplying a row by a nonzero scalar multiplies the determinant by the same scalar
		- Adding to one row a scalar multiple of another does not change the determinant.

		If Gaussian elimination applied to a square matrix A produces a row echelon matrix B, 
		let d be the product of the scalars by which the determinant has been multiplied, using the above rules.
		Then the determinant of A is the quotient by d of the product of the elements of the diagonal of B: 
		
		det(A) = produkt(diag(B))/d
		
		d kann ignoriert werden, da wir nur wissen wollen ob det(A) != 0
		*/
		double determinand = 1;
		for(int i=0; i<dim; i++) {
			determinand *= augmentedMatrix[i][i];
		}
		
		
		
		// turn matrix into reduced row echelon form
		for(int col=dim-1; col>0; col--) {
			/*
			 * todo: swap rows to prevent divison by 0
			 */
			
			
			
			for(int k=col-1; k>=0; k--) {
				double factor = augmentedMatrix[k][col]/augmentedMatrix[col][col];
				
				for(int j=0; j<augmentedMatrix[k].length; j++) {
					augmentedMatrix[k][j] = augmentedMatrix[k][j] - augmentedMatrix[col][j]*factor;
				}
			}
		}
		System.out.println("reduced row echelon form: ");
		printMatrix(augmentedMatrix);
		
		
		// Diagonale Normalisieren
		for(int i=0; i<dim; i++) {
			double factor = 1/augmentedMatrix[i][i];
			
			for(int j=0; j<augmentedMatrix[i].length; j++) {
				augmentedMatrix[i][j] = augmentedMatrix[i][j]*factor;
			}
		}
		System.out.println("normalized: ");
		printMatrix(augmentedMatrix);
		// solution = [x1, x2, ..., (1,0,-1)] 1 = Eindeutig, 0 = keine lösung, -1 = mehrere Lösungen
		for(int i=0; i<augmentedMatrix.length; i++) {
			solution[i] = augmentedMatrix[i][dim];
		}
		// Das Gleichungssystem ist genau dann eindeutig lösbar, wenn der Wert der Determinante der Koeffizientenmatrix ungleich null ist.
		solution[dim] = determinand != 0 ? 1 : 99;
		return solution;
	}

	public static double[][] swapMartixRows(double[][] matrix, int rowIndex1, int rowIndex2){
		double[] row1 = new double[matrix[0].length];
		double[] row2 = new double[matrix[0].length];
		
		for(int i=0; i<matrix[0].length; i++) {
			row1[i] = matrix[rowIndex1][i];
			row2[i] = matrix[rowIndex2][i];
		}
		
		for(int i=0; i<matrix[0].length; i++) {
			matrix[rowIndex1][i] = row2[i];
			matrix[rowIndex2][i] = row1[i];
		}
		return matrix;
	}
}
