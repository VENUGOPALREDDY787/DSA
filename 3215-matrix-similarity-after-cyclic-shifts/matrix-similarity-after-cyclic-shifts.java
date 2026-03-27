class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;
        int m = mat.length;
        int[][] result = new int[m][n]; 
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                result[i][j] = mat[i][(j+k)%n];
            }
        }
        for(int i = 0 ; i<m;i++){
            for(int j = 0; j<n;j++){
               if(result[i][j] != mat[i][j]){
                return false;
               }
            }
        }
        return true;
    }
}