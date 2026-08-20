class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>(); // will store values (could store indices too)

        // Iterate from right to left across a logical array of length 2*n
        for (int i = 2 * n - 1; i >= 0; i--) {
            int current = nums[i % n];

            // Pop all elements that are <= current, because they can't be next greater
            while (!st.isEmpty() && st.peek() <= current) {
                st.pop();
            }

            // Only fill results when i < n (first pass for original positions)
            if (i < n) {
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }

            // Push current as a candidate for earlier elements
            st.push(current);
        }
        return nge;
    }
}