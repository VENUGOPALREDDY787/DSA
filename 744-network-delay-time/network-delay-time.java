import java.util.*;

class Solution {

    class Edge {
        int u, v, wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    class Pair implements Comparable<Pair> {
        int n;
        int path;

        Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        public int compareTo(Pair p) {
            return this.path - p.path;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<Edge>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];

            graph[u].add(new Edge(u, v, wt));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k, 0));

        boolean[] vis = new boolean[n + 1];

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.n;

            if (vis[u]) continue;
            vis[u] = true;

            for (Edge e : graph[u]) {
                if (dist[u] + e.wt < dist[e.v]) {
                    dist[e.v] = dist[u] + e.wt;
                    pq.add(new Pair(e.v, dist[e.v]));
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;

            max = Math.max(max, dist[i]);
        }

        return max;
    }
}