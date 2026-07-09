class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int batchId  = 0;
        int[] batch = new int[n];
        batch[0] = batchId;
        for(int i = 1;i<n;i++){
            if(nums[i]-nums[i-1]>maxDiff){
                batchId++;
            }
            batch[i] = batchId;
        }
        boolean[] res = new boolean[queries.length];
        for(int i = 0; i<queries.length;i++){
            int u = queries[i][0];
            int v = queries[i][1];
            if(batch[u] == batch[v]){
                res[i] = true;
            }
        }
        return res;
    }
}