class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        helper(ans, new ArrayList<>(), nums, 0);

        return ans;
    }

    public void helper(List<List<Integer>> ans,
                       List<Integer> curr,
                       int[] nums,
                       int start) {

        ans.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            curr.add(nums[i]);

            helper(ans, curr, nums, i + 1);

            curr.remove(curr.size() - 1);
        }
    }
}