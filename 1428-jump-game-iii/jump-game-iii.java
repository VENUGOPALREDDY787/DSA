class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return helper(arr, start, visited);
    }

    public boolean helper(int[] arr, int i, boolean[] visited) {

        // out of bounds
        if(i < 0 || i >= arr.length) {
            return false;
        }

        // already visited
        if(visited[i]) {
            return false;
        }

        // found 0
        if(arr[i] == 0) {
            return true;
        }

        visited[i] = true;

        // move right or left
        return helper(arr, i + arr[i], visited) ||
               helper(arr, i - arr[i], visited);
    }
}