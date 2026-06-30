class Solution {
    static int count;
    public int removeStones(int[][] stones) {
        count = 0;
        int n = stones.length;
        boolean vis[] = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!vis[i]){
                count--;
            dfs(stones,i,vis);
            }
        }
        return count;
    }
    public void dfs(int[][] stones, int i,boolean vis[]){
        vis[i] = true;
        count++;
        for(int j = 0;j<stones.length;j++){
            int x= stones[j][0];
            int y = stones[j][1];
            if(!vis[j] && (x==stones[i][0] || y == stones[i][1])){
                dfs(stones,j,vis);
            }
        }
    }
};
 
