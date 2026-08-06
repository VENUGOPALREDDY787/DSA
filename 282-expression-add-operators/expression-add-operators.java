class Solution {

    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", num, target, 0, 0, 0);
        return ans;
    }

    public void backtrack(List<String> ans,
                          String path,
                          String num,
                          int target,
                          int index,
                          long value,
                          long prev) {

        if (index == num.length()) {
            if (value == target) {
                ans.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {

            // Prevent numbers like 05, 001
            if (i != index && num.charAt(index) == '0')
                break;

            String currStr = num.substring(index, i + 1);
            long curr = Long.parseLong(currStr);

            if (index == 0) {
                // First number, no operator before it
                backtrack(ans, currStr, num, target,
                        i + 1, curr, curr);
            } else {

                // +
                backtrack(ans,
                        path + "+" + currStr,
                        num,
                        target,
                        i + 1,
                        value + curr,
                        curr);

                // -
                backtrack(ans,
                        path + "-" + currStr,
                        num,
                        target,
                        i + 1,
                        value - curr,
                        -curr);

                // *
                backtrack(ans,
                        path + "*" + currStr,
                        num,
                        target,
                        i + 1,
                        value - prev + prev * curr,
                        prev * curr);
            }
        }
    }
}