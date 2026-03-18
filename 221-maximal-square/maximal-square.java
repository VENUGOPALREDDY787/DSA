class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        for(int i =0;i<m;i++){
            for(int j = 0 ;j<n;j++){
                if(j == 0 || i == 0){
                   if(matrix[i][j] == '1'){
                    dp[i][j] = 1;
                   }
                }else{
                    if(matrix[i][j] == '1'){
                        dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                    }else{
                        dp[i][j] =0;
                    }
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}