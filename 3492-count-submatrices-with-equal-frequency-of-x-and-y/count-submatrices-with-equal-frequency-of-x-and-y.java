class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] x = new int[m];
        int[] y = new int[m];
        int count = 0;
        for(int i = 0; i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] =='X'){
                    x[j]++;
                }if(grid[i][j] =='Y'){
                    y[j]++;
                }
            }
            int xsum = 0;
            int ysum = 0;
            for(int j = 0;j<m;j++){
                xsum+=x[j];
                ysum+=y[j];
                if(xsum!=0 && (ysum!= 0 && xsum== ysum)){
                    count++;
                }
            }
        }
        return count;
    }
}