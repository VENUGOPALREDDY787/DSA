class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visted = new boolean[m][n];
        for(int i = 0;i<n;i++){
            if(board[0][i] == 'O'&& !visted[0][i]){
                dfs(board,visted,0,i);
            }
            if(board[m-1][i]=='O' && !visted[m-1][i]){
                dfs(board,visted,m-1,i);
            }
        }
        for(int i =0;i<m;i++){
            if(board[i][0] =='O' && !visted[i][0]){
                dfs(board,visted,i,0);
            }if(board[i][n-1] =='O' && !visted[i][n-1]){
                dfs(board,visted,i,n-1);
            }
        }
        for(int i = 0;i<m;i++){
            for(int j = 0; j<n;j++){
                if(board[i][j] =='O' && !visted[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    public static void dfs(char[][] board,boolean[][] visted,int i,int j){
        int n = board.length;
        int m = board[0].length;
        if(i>n-1||j>m-1||j<0||i<0||board[i][j] == 'X'||visted[i][j]){
            return;
        }
        visted[i][j] = true;
        dfs(board,visted,i+1,j);
        dfs(board,visted,i-1,j);
        dfs(board,visted,i,j+1);
        dfs(board,visted,i,j-1);
    }
}