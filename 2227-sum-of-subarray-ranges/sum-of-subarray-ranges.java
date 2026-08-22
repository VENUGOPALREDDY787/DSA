class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] right = new int[n];
        int[] left = new int[n];
        int[] rightmax = new int[n];
        int[] leftmax = new int[n];

        Stack<Integer> sc = new Stack<>();

        // Next smaller element
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];

            while (!sc.isEmpty() && nums[sc.peek()] >= num) {
                sc.pop();
            }

            right[i] = sc.isEmpty() ? n - i : sc.peek() - i;
            sc.push(i);
        }

        sc.clear();

        // Previous smaller element
        for (int i = 0; i < n; i++) {
            int num = nums[i];

            while (!sc.isEmpty() && nums[sc.peek()] > num) {
                sc.pop();
            }

            left[i] = sc.isEmpty() ? i + 1 : i - sc.peek();
            sc.push(i);
        }

        sc.clear();

        // Next greater element
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];

            while (!sc.isEmpty() && nums[sc.peek()] <= num) {
                sc.pop();
            }

            rightmax[i] = sc.isEmpty() ? n - i : sc.peek() - i;
            sc.push(i);
        }

        sc.clear();

        // Previous greater element
        for (int i = 0; i < n; i++) {
            int num = nums[i];

            while (!sc.isEmpty() && nums[sc.peek()] < num) {
                sc.pop();
            }

            leftmax[i] = sc.isEmpty() ? i + 1 : i - sc.peek();
            sc.push(i);
        }

        long max = 0;
        long min = 0;

        for (int i = 0; i < n; i++) {
            max += (long) nums[i] * rightmax[i] * leftmax[i];
            min += (long) nums[i] * right[i] * left[i];
        }

        return max - min;
    }
}