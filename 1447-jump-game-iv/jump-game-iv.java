class Solution {
    public int minJumps(int[] arr) {

        int n = arr.length;

        HashMap<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp.putIfAbsent(arr[i], new ArrayList<>());
            mp.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        boolean[] vis = new boolean[n];
        vis[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int i = q.poll();

                if (i == n - 1)
                    return steps;

                if (i > 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.offer(i - 1);
                }

                if (i < n - 1 && !vis[i + 1]) {
                    vis[i + 1] = true;
                    q.offer(i + 1);
                }

                if (mp.containsKey(arr[i])) {

                    for (int idx : mp.get(arr[i])) {

                        if (!vis[idx]) {
                            vis[idx] = true;
                            q.offer(idx);
                        }
                    }

                    mp.remove(arr[i]);
                }
            }

            steps++;
        }

        return -1;
    }
}