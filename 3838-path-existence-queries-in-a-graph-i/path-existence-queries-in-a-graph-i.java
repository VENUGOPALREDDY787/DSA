class Solution {
    public static int[] rank;
    public static int[] par;

    public int find(int x) {
        if (par[x] != x) {
            par[x] = find(par[x]); // Path Compression
        }
        return par[x];
    }

    public void union(int x, int y) {
        int parX = find(x);
        int parY = find(y);

        if (parX == parY) return;

        if (rank[parX] == rank[parY]) {
            par[parY] = parX;
            rank[parX]++;
        } else if (rank[parX] < rank[parY]) {
            par[parX] = parY;
        } else {
            par[parY] = parX;
        }
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        rank = new int[n];
        par = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        // Build DSU
        for (int i = 0; i < n-1; i++) {
           if(nums[i+1]-nums[i]<=maxDiff){
            union(i,i+1);
           }
        }

        boolean[] res = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            if (find(u) == find(v)) {
                res[i] = true;
            }
        }

        return res;
    }
}