
import java.lang.*;

public final class SparsMatrix {

	private final int sparse[][];
	private final int rows;
	private final int columns;

	SparsMatrix(int matrix[][], int rows, int columns) {

		this.sparse = matrix;
		this.rows = rows;
		this.columns = columns;
	}

	/*
	 * Compute Transpose of Given sparse matrix
	 * 
	 * @param nothing
	 * 
	 * @return int[][] - Transpose of Sparse matrix Let n = number of elements ,
	 * c = number of Columns Time Complexity - O( n + c )
	 */
	public int[][] transpose() throws ArrayIndexOutOfBoundsException {

		int countCol[] = new int[this.columns + 1];
		for (int i = 0; i < this.columns; i++) {
			countCol[i] = 0;
		}

		for (int i = 0; i < this.sparse.length; i++) {
			countCol[this.sparse[i][1]]++;
		}

		for (int i = 1; i < this.columns; i++) {
			countCol[i] += countCol[i - 1];
		}

		System.out.println("");
		int transposeOfSparse[][] = new int[this.sparse.length][3];

		for (int i = this.sparse.length - 1; i >= 0; i--) {
			int indexOfCol = countCol[this.sparse[i][1]] - 1;
			transposeOfSparse[indexOfCol][0] = this.sparse[i][1];
			transposeOfSparse[indexOfCol][1] = this.sparse[i][0];
			transposeOfSparse[indexOfCol][2] = this.sparse[i][2];
			countCol[this.sparse[i][1]]--;
		}

		return transposeOfSparse;
	}

	/*
	 * Check whether Sparse matrix is Symmetrical matrix of not
	 * 
	 * @param nothing
	 * 
	 * @return true if it is symmetrical matrix otherwise false Let n1 = number
	 * of elements in sparse matrix n2 = number of elements in transpose matrix
	 * Time Complexity - O( max( n1, n2) ) if rows == columns O(1) if rows !=
	 * columns
	 */
	public boolean isSymmetricalMatrix() throws ArrayIndexOutOfBoundsException {

		if (this.rows != this.columns) {
			return false;
		}

		int transposeMatrix[][] = this.transpose();

		for (int i = 0, j = 0; i < this.sparse.length
				&& j < transposeMatrix.length; i++, j++) {
			if (this.sparse[i][0] != transposeMatrix[i][0]) {
				return false;
			} else {
				if (this.sparse[i][1] != transposeMatrix[i][1]) {
					return false;
				} else {
					if (this.sparse[i][2] != transposeMatrix[i][2]) {
						return false;
					}
				}
			}
		}
		return true;
	}
}