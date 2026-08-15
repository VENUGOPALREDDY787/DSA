class Solution {
    public int maxScore(int[] nums, int k) {
        int n = nums.length;

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int windowSize = n - k;

        // If k == n, take everything
        if (windowSize == 0) {
            return total;
        }

        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += nums[i];
        }

        int minWindow = windowSum;

        for (int i = windowSize; i < n; i++) {
            windowSum += nums[i];
            windowSum -= nums[i - windowSize];

            minWindow = Math.min(minWindow, windowSum);
        }

        return total - minWindow;
    }
}