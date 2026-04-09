class Solution {
    public boolean search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates
            if (nums[si] == nums[mid] && nums[mid] == nums[ei]) {
                si++;
                ei--;
            }
            // Left half is sorted
            else if (nums[si] <= nums[mid]) {
                if (nums[si] <= target && target < nums[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }
        }
        return false;
    }
}