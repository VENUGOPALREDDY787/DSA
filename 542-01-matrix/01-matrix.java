class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        int INF = m + n;  // maximum possible distance

        // Step 1: Replace all 1s with large value
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] != 0){
                    mat[i][j] = INF;
                }
            }
        }

        // Step 2: Top-Left → Bottom-Right
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(mat[i][j] == 0) continue;

                if(i > 0)
                    mat[i][j] = Math.min(mat[i][j], mat[i-1][j] + 1);

                if(j > 0)
                    mat[i][j] = Math.min(mat[i][j], mat[i][j-1] + 1);
            }
        }

        // Step 3: Bottom-Right → Top-Left
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){

                if(mat[i][j] == 0) continue;

                if(i < n-1)
                    mat[i][j] = Math.min(mat[i][j], mat[i+1][j] + 1);

                if(j < m-1)
                    mat[i][j] = Math.min(mat[i][j], mat[i][j+1] + 1);
            }
        }

        return mat;
    }
}