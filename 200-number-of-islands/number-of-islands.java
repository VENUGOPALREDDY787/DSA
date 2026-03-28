class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visted = new boolean[n][m];
        for(int i = 0; i<n;i++){
            for(int j =0;j<m;j++){
                if(!visted[i][j] && grid[i][j] == '1'){
                    count++;
                    bfs(grid,visted,i,j);
                }
            }
        }
        return count;
    }
    public static void bfs(char[][] grid,boolean[][] visted,int i,int j){
        
        int n = grid.length;
        int m = grid[0].length;
        if(i<0||j<0||j>m-1||i>n-1||grid[i][j]=='0'||visted[i][j])return;
        visted[i][j] = true;
        bfs(grid,visted,i+1,j);
         bfs(grid,visted,i-1,j);
          bfs(grid,visted,i,j+1);
           bfs(grid,visted,i,j-1);
    }
}