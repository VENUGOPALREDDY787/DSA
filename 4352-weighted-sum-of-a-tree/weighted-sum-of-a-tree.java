class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = nums.length;
        ArrayList<Integer>[] tree = new ArrayList[n];
        for(int i = 0; i<n;i++){
            tree[i] = new ArrayList<>();
        }
        int root = -1;
        for(int i = 0; i< n; i++){
            if(parent[i] == -1){
                root = i;
            }else{
                tree[parent[i]].add(i);
            }
        }
        int depth[] = new int[n];
        int height = 1;
        depth[root] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int r= q.remove();
            for(int i = 0; i<tree[r].size();i++){
                int now = tree[r].get(i);
                depth[now] = depth[r]+1;
                height = Math.max(height,depth[now]);
                q.add(now);
            }
        }
        long sum = 0;
        for(int i = 0; i< n;i++){
            long weight = (long)nums[i]*(height-depth[i]+1);
            sum +=weight;
        }
        return sum;
    }
}