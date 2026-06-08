class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ml = new ArrayList<>();
        char[][] Nqueens = new char[n][n];
        for(int i = 0; i< n;i++){
            for(int j = 0; j<n;j++){
                Nqueens[i][j] = '.';
            }
        }
        fillNQueens(ml,Nqueens,0,n);
        return ml;
    }
    public static void fillNQueens(List<List<String>> ml ,char[][] Nqueens, int j ,int n){
        if(j == n){
            List<String> li = new ArrayList<>();
            for(int i = 0; i<n;i++){
                String st = "";
                for(int k= 0;k<n;k++){
                    st =st+Nqueens[i][k];
                }
               li.add(st);
            }
            ml.add(li);
            return;
        }
       
       for(int k = 0; k<n;k++){
        if(isSafe(Nqueens,k,j)){
            Nqueens[k][j] = 'Q';
            fillNQueens(ml,Nqueens,j+1,n);
            Nqueens[k][j] ='.';
        }
       }
    }
   public static boolean isSafe(char[][] board, int row, int col){

    // left row
    for(int j=0; j<col; j++){
        if(board[row][j] == 'Q'){
            return false;
        }
    }

    // upper-left diagonal
    for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
        if(board[i][j] == 'Q'){
            return false;
        }
    }

    // lower-left diagonal
    for(int i=row+1, j=col-1; i<board.length && j>=0; i++, j--){
        if(board[i][j] == 'Q'){
            return false;
        }
    }

    return true;
}
}