class Solution {

    public String longestPalindrome(String s) {

        int start = 0;
        int size = 1;

        for (int i = 0; i < s.length(); i++) {

            for (int j = i + size; j < s.length(); j++) {

                if (isPalindrome(s, i, j)) {

                    start = i;
                    size = j - i + 1;
                }
            }
        }

        return s.substring(start, start + size);
    }

    public static boolean isPalindrome(String s, int i, int j) {

        while (i < j) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}