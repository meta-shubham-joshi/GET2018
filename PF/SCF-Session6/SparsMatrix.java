import java.util.ArrayList;

public final class SparsMatrix {

	private final int sparsematrix[][];
	private final int row;
	private final int col;

	public SparsMatrix(int[][] arr, int rows, int column) {

		this.sparsematrix = arr;
		this.row = rows;
		this.col = column;

	}

	/*
	 * transpose of matrix
	 */
	public int[][] transposeOfMatrix() {

		int countcolumn[] = new int[this.col + 1];
		for (int i = 0; i < this.col; i++) {
			countcolumn[i] = 0;
		}

		for (int i = 0; i < this.sparsematrix.length; i++) {
			countcolumn[this.sparsematrix[i][1]]++;
		}

		for (int i = 1; i < this.col; i++) {
			countcolumn[i] = countcolumn[i - 1] + 1;
		}

		int[][] sparsetranspose = new int[this.sparsematrix.length][3];

		for (int i = this.sparsematrix.length - 1; i >= 0; i--) {
			int j = countcolumn[this.sparsematrix[i][1]] - 1;
			sparsetranspose[j][0] = this.sparsematrix[i][1];
			sparsetranspose[j][1] = this.sparsematrix[i][0];
			sparsetranspose[j][2] = this.sparsematrix[i][2];
			countcolumn[this.sparsematrix[i][1]]--;
		}

		return sparsetranspose;
	}

	/*
	 * symmetrical or not
	 */
	public boolean isSymmetrical() {

		if (this.row != this.col) {
			return false;
		}

		int transpose[][] = this.transposeOfMatrix();

		for (int i = 0, j = 0; i < this.sparsematrix.length
				&& j < transpose.length; i++, j++) {
			if (this.sparsematrix[i][0] != transpose[i][0]) {
				return false;
			} else {
				if (this.sparsematrix[i][1] != transpose[i][1]) {
					return false;
				} else {
					if (this.sparsematrix[i][2] != transpose[i][2]) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public int[][] addsparsematrix(int sparse1[][], int sparse2[][]) {

		int len1 = sparse1.length;
		int len2 = sparse2.length;
		int i;
		int j;

		ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
		int size;
		ArrayList<Integer> in = new ArrayList<Integer>();
		
		for (i = 0, j = 0; i < len1 && j < len2;) {


			if (sparse1[i][0] == sparse2[j][0]
					&& sparse1[i][1] == sparse2[j][1]) {
				in.add(sparse1[i][0]);
				in.add(sparse1[i][1]);
				in.add(sparse1[i][2]);
				out.add(in);
				i++;
				j++;
			} else if (sparse1[i][0] < sparse2[j][0]) {
				in.add(sparse1[i][0]);
				in.add(sparse1[i][1]);
				in.add(sparse1[i][2]);
				out.add(in);
				i++;
			} else if (sparse1[i][0] > sparse2[j][0]) {
				in.add(sparse2[j][0]);
				in.add(sparse2[j][1]);
				in.add(sparse2[j][2]);
				out.add(in);
				j++;
			} else if ((sparse1[i][0] == sparse2[j][0])
					&& (sparse1[i][1] > sparse2[j][1])) {
				in.add(sparse2[j][0]);
				in.add(sparse2[j][1]);
				in.add(sparse2[j][2]);
				out.add(in);
				j++;
			} else {
				in.add(sparse2[i][0]);
				in.add(sparse2[i][1]);
				in.add(sparse2[i][2]);
				out.add(in);
			}
		}
		
		size = out.size();
		
		int[][] ans = new int[size][3];
		ArrayList<Integer> var = new ArrayList<Integer>();
		
		for(int p=0;p<size;i++){
			ans[p][0] = out.get(p).get(0);
			ans[p][1] = out.get(p).get(1);
			ans[p][2] = out.get(p).get(2);
			}
		
		return ans;
		}
	
		
	public int[][] multiplySparseMatrix(int[][] sparse1,int[][] sparse2){
		
		int size1=sparse1[0].length;
		int size2=sparse2.length;
		
		if(size1!=size2)
			return;
		
		for(int i=0;i<sparse1.length;i++){
			
			int row = sparse1[i][0];
			int col = sparse1[i][1];
			
			for(j=0;j<sparse2.length;j++){
				
				if(sparse2[j][1]==col){
					
					
				}
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
