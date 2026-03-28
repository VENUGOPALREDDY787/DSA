class Solution {
    public boolean isBipartite(int[][] graph) {
        HashSet<Integer> left = new HashSet<>();
        HashSet<Integer> right = new HashSet<>();
        boolean[] visted = new boolean[graph.length];
        for(int i = 0; i< graph.length;i++){
            if(!visted[i]){
                if(!bfs(graph,visted,left,right,i))return false;
            }
        }
        return true;
    }
    public static boolean bfs(int[][] graph, boolean[] visted,HashSet<Integer> left ,HashSet<Integer> right, int node){
        visted[node] = true;
        for(int i = 0;i<graph[node].length;i++){
            int nib = graph[node][i];
            if(left.contains(node)&& left.contains(nib))return false;
            if(right.contains(node)&& right.contains(nib))return false;
            if(left.contains(node)){
                    right.add(nib);
                
            }else{
                left.add(nib);
            }
            if(!visted[nib]){
                 if (!bfs(graph, visted, left, right, nib)) {
                    return false;
                }
            }
        }
        return true;
    }
}