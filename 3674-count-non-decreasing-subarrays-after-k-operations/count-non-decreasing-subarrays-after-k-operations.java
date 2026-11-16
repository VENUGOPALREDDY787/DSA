
import java.util.*;

class Solution {

    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        // Prefix Sum
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Step 1: Next Greater Element
        int[] NGR = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!s.isEmpty() &&
                   nums[s.peek()] <= nums[i]) {
                s.pop();
            }

            NGR[i] = s.isEmpty() ? n : s.peek();

            s.push(i);
        }

        // Step 2: Calculate operations
        long[] operations = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            int m = NGR[i];

            long segment =
                (long) nums[i] * (m - i)
                - (prefix[m] - prefix[i]);

            operations[i] = segment + operations[m];
        }

        // Step 3: Sliding Window + Monotonic Deque
        Deque<Integer> deq = new ArrayDeque<>();

        int i = 0;
        long result = 0;

        for (int j = 0; j < n; j++) {

            while (!deq.isEmpty() &&
                   nums[deq.peekLast()] <= nums[j]) {
                deq.pollLast();
            }

            deq.addLast(j);

            while (i <= j) {

                int m = deq.peekFirst();

                long oprnsCount =
                    (operations[i] - operations[m])
                    + (long) nums[m] * (j - m + 1)
                    - (prefix[j + 1] - prefix[m]);

                if (oprnsCount <= k) {
                    break;
                }

                i++;

                if (!deq.isEmpty() && deq.peekFirst() < i) {
                    deq.pollFirst();
                }
            }

            result += j - i + 1;
        }

        return result;
    }
}
