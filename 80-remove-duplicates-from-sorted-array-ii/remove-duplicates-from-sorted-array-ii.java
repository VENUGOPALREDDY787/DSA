class Solution {
    public int removeDuplicates(int[] nums) {

        int count = 0;
        int res = nums.length;
        int val = nums[0];

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == val) {
                count++;
            } else {
                val = nums[i];
                count = 1;
            }

            if (count > 2) {
                nums[i] = Integer.MAX_VALUE;
                res--;
            }
        }

        Arrays.sort(nums);
        return res;
    }
}