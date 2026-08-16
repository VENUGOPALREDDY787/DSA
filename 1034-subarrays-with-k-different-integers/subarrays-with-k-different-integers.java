class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        int n = nums.length;
        int i = 0;
        int j = 0;

        while (j < n) {
            int now = nums[j];
            map.put(now, map.getOrDefault(now, 0) + 1);

            while (map.size() > k) {
                int m = nums[i];

                map.put(m, map.get(m) - 1);

                if (map.get(m) == 0) {
                    map.remove(m);
                }

                i++;
            }

            // Number of valid subarrays ending at j
            count += j - i + 1;

            j++;
        }

        return count;
    }
}