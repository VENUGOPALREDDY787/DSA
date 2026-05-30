class Solution {
    public int minMoves(int[] nums, int limit) {
        int[] arr = new int[2 * limit + 2];
        int n = nums.length;

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            int low = Math.min(a, b) + 1;
            int high = Math.max(a, b) + limit;
            int sum = a + b;

            arr[2] += 2;
            arr[2 * limit + 1] -= 2;

            arr[low]--;
            arr[high + 1]++;

            arr[sum]--;
            arr[sum + 1]++;
        }

        int ans = Integer.MAX_VALUE;
        int curr = 0;

        for (int s = 2; s <= 2 * limit; s++) {
            curr += arr[s];
            ans = Math.min(ans, curr);
        }

        return ans;
    }
}