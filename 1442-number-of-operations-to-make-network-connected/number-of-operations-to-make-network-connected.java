class Solution {

    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1) {
            return -1;
        }

        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] vis = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(graph, vis, i);
                components++;
            }
        }

        return components - 1;
    }

    public void dfs(ArrayList<Integer>[] graph, boolean[] vis, int node) {
        vis[node] = true;

        for (int neigh : graph[node]) {
            if (!vis[neigh]) {
                dfs(graph, vis, neigh);
            }
        }
    }
}