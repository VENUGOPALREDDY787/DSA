import java.util.*;

class Solution {
    class Pair {
        int dest, price;
        Pair(int d, int p) { dest = d; price = p; }
    }

    class State {
        int node, cost, stops;
        State(int n, int c, int s) { node = n; cost = c; stops = s; }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] f : flights) graph.get(f[0]).add(new Pair(f[1], f[2]));

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        Queue<State> q = new LinkedList<>();
        q.offer(new State(src, 0, 0));

        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.stops > k) continue;

            for (Pair next : graph.get(cur.node)) {
                int newCost = cur.cost + next.price;
                if (newCost < minCost[next.dest]) {
                    minCost[next.dest] = newCost;
                    q.offer(new State(next.dest, newCost, cur.stops + 1));
                }
            }
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}