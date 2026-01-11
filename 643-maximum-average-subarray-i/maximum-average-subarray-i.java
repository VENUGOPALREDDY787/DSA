class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int val = 0;

        // First window sum
        for (int i = 0; i < k; i++) {
            val += nums[i];
        }

        int maxVal = val;

        // Sliding window
        for (int i = k; i < nums.length; i++) {
            val -= nums[i - k];   // remove left element
            val += nums[i];       // add right element
            maxVal = Math.max(maxVal, val);
        }

        return (double) maxVal / k;
    }
}
