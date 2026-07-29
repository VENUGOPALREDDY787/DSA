class Solution {
    public int minCost(int n, int[] cuts) {
        int[] cut = new int[cuts.length + 2];

        cut[0] = 0;
        cut[cut.length - 1] = n;

        for (int i = 0; i < cuts.length; i++) {
            cut[i + 1] = cuts[i];
        }

        Arrays.sort(cut);
    int[][] dp = new int[cut.length+1][cut.length+1];
    for(int i = 0; i<cut.length;i++){
        for(int j = 0; j<cut.length;j++){
            dp[i][j] = -1;
        }
    }

        return solve(0, cut.length - 1, cut,dp);
    }

    public int solve(int l, int r, int[] cut,int[][] dp) {

        if (r - l == 1)
            return 0;
    if(dp[l][r] != -1){
        return dp[l][r];
    }
        int min = Integer.MAX_VALUE;
        int cost = cut[r] - cut[l];

        for (int i = l + 1; i <= r - 1; i++) {
            min = Math.min(min,
                    solve(l, i, cut,dp) +
                    solve(i, r, cut,dp) +
                    cost);
        }

        return dp[l][r] =min;
    }
}