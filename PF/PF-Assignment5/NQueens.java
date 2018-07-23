
public class NQueens {
	
	/* Checks whether we can place a particular chess queen on a position or not.
	 * @params board- Contains the position matrix.
	 * @params row-row number.
	 * @params col-column number.
	 * @return whether a particular index is suitable for entering the chess queen or not.
	 */
	
	public boolean isSafe(int board[][],int row,int col)
	{
		int i,j;
		
		// checking on the left side of the column
		for(i=0;i<col;i++){
			if(board[row][i]==1)
				return false;
		}
		
		// checking on the upper diagonal
		for(i=row,j=col; i>=0 && j>=0; i--,j--){
			if(board[i][j]==1)
				return false;
		}
		
		// checking on the lower diagonal
		for(i=row,j=col; j>=0 && i<board[0].length ; i++,j--){
			if(board[i][j]==1)
				return false;
		}
		
		return true;
	}
	
	/* Checks whether we can place chess queen appropriately so that there will be no attack on each other.
	 * @params board- Contains the position matrix.
	 * @params col-column number.
	 * @return whether a particular index is suitable for entering the chess queen or not.
	 */
	
	public boolean solveNUtils(int board[][],int col)
	{
		if(col>=board[0].length)
			return true;
		
		for(int i=0;i<board[0].length;i++){
			
			// column input will be given 0
			if(isSafe(board,i,col)){
				
				board[i][col]=1;
				
				// inputting the next value
				if(solveNUtils(board,col+1))
					return true;
				
				board[i][col]=0;
				
		}
		
	}
		return false;

}
}

