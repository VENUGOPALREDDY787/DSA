class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        // prefix sum
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        long maxValue = Long.MIN_VALUE;

        // try all starting points from 0 to k-1
        for (int start = 0; start < k; start++) {

            long currSum = 0;

            // jump in steps of k
            for (int i = start; i + k - 1 < n; i += k) {

                int j = i + k - 1;

                long subSum = (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];

                // Kadane on these blocks
                currSum = Math.max(subSum, currSum + subSum);

                maxValue = Math.max(maxValue, currSum);
            }
        }

        return maxValue;
    }
}