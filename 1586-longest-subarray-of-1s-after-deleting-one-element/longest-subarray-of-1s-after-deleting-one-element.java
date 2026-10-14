
class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int zeroCount = 0;
        int n = nums.length;
        int max = 0;

        while (j < n) {
            if (nums[j] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[i] == 0) {
                    zeroCount--;
                }
                i++;
            }

            j++;
            max = Math.max(max, j - i - 1);
        }

        return max;
    }
}
