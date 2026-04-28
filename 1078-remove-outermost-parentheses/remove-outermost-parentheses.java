class Solution {
    public String removeOuterParentheses(String s) {
        int open = 0;
        int close = 0;
        String result = "";
        int last = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                result += s.substring(last + 1, i);
                last = i + 1;
                open = 0;
                close = 0;
            }
        }
        return result;
    }
}