class Solution {

    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        long MOD = 1000000007L;

        long[] left = new long[n];
        long[] right = new long[n];

        Stack<Integer> st = new Stack<>();

        // Find previous smaller element
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left[i] = i + 1;
            } else {
                left[i] = i - st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Find next smaller or equal element
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                right[i] = n - i;
            } else {
                right[i] = st.peek() - i;
            }

            st.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {

            long contribution =
                    ((long) arr[i] * left[i]) % MOD;

            contribution =
                    (contribution * right[i]) % MOD;

            ans = (ans + contribution) % MOD;
        }

        return (int) ans;
    }
}