class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count =0 ;
        boolean[][] visted = new boolean[n][m];
        for(int i = 0 ; i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if((i ==0|| j==0||i==n-1||j==m-1)&&(grid[i][j] ==1)){
                    dfs(grid,visted,i,j);
                }
            }
        }
        for(int i =0; i< n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] ==1 && !visted[i][j]){
                    count+=1;
                }
            }
        }
        return count;
    }
    public static void dfs(int[][] grid,boolean[][] visted,int r, int c ){
         int m = grid.length;
        int n = grid[0].length;

        if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] != 1||visted[r][c]){
            return;
        }

        visted[r][c] = true;

        dfs(grid,visted, r + 1, c);
        dfs(grid, visted,r - 1, c);
        dfs(grid,visted, r, c + 1);
        dfs(grid,visted, r, c - 1);
    }
}