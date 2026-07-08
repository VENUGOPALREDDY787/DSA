class Solution {

    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        // cnt[i] = number of non-zero digits in s[0...i-1]
        int[] cnt = new int[n + 1];

        for (int i = 0; i < n; i++) {
            cnt[i + 1] = cnt[i] + (s.charAt(i) != '0' ? 1 : 0);
        }

        int k = cnt[n];

        long[] hash = new long[k + 1];
        long[] pow10 = new long[k + 1];
        long[] digitSum = new long[k + 1];

        pow10[0] = 1;

        for (int i = 1; i <= k; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        int idx = 1;

        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            if (c == '0')
                continue;

            int d = c - '0';

            hash[idx] = (hash[idx - 1] * 10 + d) % MOD;
            digitSum[idx] = digitSum[idx - 1] + d;

            idx++;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int L = cnt[l];
            int R = cnt[r + 1];

            if (L == R) {
                ans[i] = 0;
                continue;
            }

            int len = R - L;

            long x = (hash[R] - hash[L] * pow10[len]) % MOD;

            if (x < 0)
                x += MOD;

            long sum = digitSum[R] - digitSum[L];

            ans[i] = (int) ((x * (sum % MOD)) % MOD);
        }

        return ans;
    }
}