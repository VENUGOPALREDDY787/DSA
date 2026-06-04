class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ml = new ArrayList<>();
        List<Integer> li = new ArrayList<>();

        helper(ml, li, 1, k, n);

        return ml;
    }

    public static void helper(List<List<Integer>> ml,
                              List<Integer> li,
                              int idx,
                              int k,
                              int n) {

        if (n == 0 && k == 0) {
            ml.add(new ArrayList<>(li));
            return;
        }

        if (n < 0 || k < 0)
            return;

        for (int i = idx; i <= 9; i++) {
            li.add(i);

            helper(ml, li, i + 1, k - 1, n - i);

            li.remove(li.size() - 1);
        }
    }
}