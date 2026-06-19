import java.util.*;

class Solution {
    class eage {
        int i;
        int j;
        int time;

        public eage(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<eage> q = new LinkedList<>();

        // Add all rotten oranges to queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new eage(i, j, 0));
                    vis[i][j] = true;   // mark visited here
                }
            }
        }

        int time = 0;

        while (!q.isEmpty()) {
            eage now = q.poll();
            int i = now.i;
            int j = now.j;
            time = now.time;

            // Up
            if (i - 1 >= 0 && !vis[i - 1][j] && grid[i - 1][j] == 1) {
                vis[i - 1][j] = true;
                q.add(new eage(i - 1, j, time + 1));
            }

            // Down
            if (i + 1 < n && !vis[i + 1][j] && grid[i + 1][j] == 1) {
                vis[i + 1][j] = true;
                q.add(new eage(i + 1, j, time + 1));
            }

            // Left
            if (j - 1 >= 0 && !vis[i][j - 1] && grid[i][j - 1] == 1) {
                vis[i][j - 1] = true;
                q.add(new eage(i, j - 1, time + 1));
            }

            // Right
            if (j + 1 < m && !vis[i][j + 1] && grid[i][j + 1] == 1) {
                vis[i][j + 1] = true;
                q.add(new eage(i, j + 1, time + 1));
            }
        }

        // Check if any fresh orange remains
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    return -1;
                }
            }
        }

        return time;
    }
}