import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        HashSet<Integer> left = new HashSet<>();
        HashSet<Integer> right = new HashSet<>();
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                left.add(i); // start node in left
                if (!dfs(graph, i, left, right, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int node,
                       HashSet<Integer> left,
                       HashSet<Integer> right,
                       boolean[] visited) {

        visited[node] = true;

        for (int neighbor : graph[node]) {

            // ❌ Conflict
            if (left.contains(node) && left.contains(neighbor)) return false;
            if (right.contains(node) && right.contains(neighbor)) return false;

            // Assign to opposite set
            if (left.contains(node)) {
                if (!right.contains(neighbor)) {
                    right.add(neighbor);
                }
            } else {
                if (!left.contains(neighbor)) {
                    left.add(neighbor);
                }
            }

            // DFS call
            if (!visited[neighbor]) {
                if (!dfs(graph, neighbor, left, right, visited)) {
                    return false;
                }
            }
        }
        return true;
    }
}