class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];
        for(int i = 0; i<graph.length;i++){
            if(!vis[i]){
                dfs(graph,i,vis,stack);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< graph.length;i++){
            if(!stack[i]){
                list.add(i);
            }
        }
        return list;
    }
    public static boolean dfs(int[][] graph,int curr,boolean[] vis,boolean[] stack){
        vis[curr] =true;
        stack[curr] = true;
        for(int i =0 ;i< graph[curr].length;i++){
            int now = graph[curr][i];
            if(stack[now]){
                return true;
            }else if(!vis[now] && dfs(graph,now,vis,stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
}