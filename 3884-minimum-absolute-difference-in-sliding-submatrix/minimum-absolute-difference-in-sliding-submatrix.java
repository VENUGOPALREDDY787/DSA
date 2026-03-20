import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n - k + 1][m - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {
                dp[i][j] = findAbsDiff(i, j, grid, k);
            }
        }
        return dp;
    }

    public int findAbsDiff(int i, int j, int[][] grid, int k) {
        int[] arr = new int[k * k];
        int g = 0;

        for (int l = i; l < i + k; l++) {
            for (int c = j; c < j + k; c++) {
                arr[g++] = grid[l][c];
            }
        }

        if (arr.length <= 1) return 0; 

        Arrays.sort(arr);

        int mindiff = Integer.MAX_VALUE;

        for (int l = 1; l < arr.length; l++) {
            if(arr[l]!=arr[l-1]){
            mindiff = Math.min(mindiff, arr[l] - arr[l - 1]);
            }
        }
        if(mindiff== Integer.MAX_VALUE)return 0;

        return mindiff;
    }
}