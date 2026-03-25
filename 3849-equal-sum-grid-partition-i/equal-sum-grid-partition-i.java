class Solution {
    public boolean canPartitionGrid(int[][] grid) {
       long sum = 0;
       for(int i =0; i<grid.length;i++){
        for(int j = 0; j<grid[0].length;j++){
            sum =sum +grid[i][j];
        }
       } 
       long halfsum = 0;
       for(int i = 0;i<grid.length;i++){
        for(int j = 0;j<grid[0].length;j++){
            halfsum= halfsum+grid[i][j];
        }
        if(2*halfsum == sum){
            return true;
        }
       }
       halfsum = 0;
       for(int i = 0;i<grid[0].length;i++){
        for(int j = 0;j<grid.length;j++){
            halfsum = halfsum+grid[j][i];
        }
        if(2*halfsum == sum){
            return true;
        }
       }
       return false;
    }
}