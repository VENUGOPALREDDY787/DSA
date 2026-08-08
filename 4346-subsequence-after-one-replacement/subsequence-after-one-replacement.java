class Solution {
    public boolean canMakeSubsequence(String s, String t) {

        int n = s.length();
        int m = t.length();

        if (n > m) return false;

        if (n == 0) {
            return true;
        }

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        int j = 0;

        // Match from left
        for (int i = 0; i < n; i++) {

            while (j < m && s.charAt(i) != t.charAt(j)) {
                j++;
            }

            if (j == m) {
                prefix[i] = m;
            } else {
                prefix[i] = j;
                j++;
            }
        }

        // Already a subsequence
        if (prefix[n - 1] != m) {
            return true;
        }

        // Match from right
        j = m - 1;

        for (int i = n - 1; i >= 0; i--) {

            while (j >= 0 && s.charAt(i) != t.charAt(j)) {
                j--;
            }

            if (j < 0) {
                suffix[i] = -1;
            } else {
                suffix[i] = j;
                j--;
            }
        }

        // Try replacing every character
        for (int i = 0; i < n; i++) {

            int left = (i == 0) ? -1 : prefix[i - 1];

            int right = (i == n - 1)
                    ? m
                    : suffix[i + 1];

            if (left + 1 < right) {
                return true;
            }
        }

        return false;
    }
}