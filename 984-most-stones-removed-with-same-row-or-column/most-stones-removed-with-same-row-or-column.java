class Solution {
  int count = 0;

  public int removeStones(int[][] stones) {
    int n = stones.length;

    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(visited, i, stones);
        count++;

      }
    }
    return n - count;

  }

  public void dfs(boolean[] visited, int node, int[][] stones) {
    visited[node] = true;

    for (int i = 0; i < stones.length; i++) {
      if (!visited[i] && (stones[node][0] == stones[i][0] || stones[node][1] == stones[i][1])) {

        dfs(visited, i, stones);

      }
    }
  }
}