class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board,0,0);
        
    }
    public static boolean backtrack(char[][] board,int i ,int j){
        if(i == board.length)return true;
        if(j == board.length)return backtrack(board,i+1,0);
        if(board[i][j] !='.')return backtrack(board,i,j+1);
        
        for(char ch = '1'; ch <= '9'; ch++){
            if(isSafe(board,i,j,ch)){
                board[i][j] =ch;
                if(backtrack(board,i,j+1)){
                    return true;
                }
              
                board[i][j] = '.';
            }
        }
        return false;
    }
    public static boolean isSafe(char[][] board,int i, int j,char ch){
        for(int n = 0; n<board.length;n++){
            if(board[n][j] == ch || board[i][n] == ch)return false;
        }
        int startRow = (i / 3) * 3;
int startCol = (j / 3) * 3;
for(int n = startRow;n<startRow+3;n++){
    for(int m = startCol;m<startCol+3;m++){
        if(board[n][m] == ch)return false;
    }
}return true;
    }
}