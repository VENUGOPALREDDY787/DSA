class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i= 0;i<numCourses;i++){
            graph[i] = new ArrayList<>();
        }
        createGraph(prerequisites,graph);
        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];
        for(int i = 0 ;i<graph.length;i++){
            if(!visited[i]){
                if(iscycle(graph,i,visited,stack))return false;
            }
        }
        return true;
       
    }
    public static void createGraph(int[][] prerequisites,ArrayList<Integer>[] graph ){
        for(int i = 0;i<prerequisites.length;i++){
                int sur = prerequisites[i][1];
                int dest = prerequisites[i][0];
                graph[sur].add(dest);
        }
    }
    public static boolean iscycle(ArrayList<Integer>[] graph,int curr,boolean[] visited,boolean[] stack){
        visited[curr] = true;
        stack[curr] = true;
        for(int i = 0; i< graph[curr].size();i++){
            int present = graph[curr].get(i);
            if(stack[present])return true;
            else if(!visited[present]&& iscycle(graph,present,visited,stack))return true;
        }
        stack[curr] =false;
        
        return false;
    }
}