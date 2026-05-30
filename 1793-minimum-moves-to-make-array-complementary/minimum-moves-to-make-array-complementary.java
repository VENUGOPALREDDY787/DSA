class Solution {
    public int minMoves(int[] nums, int limit) {
        int len = 2 * limit + 2;
        int ber = nums.length / 2;
        int n = nums.length;

        int[] arr = new int[len];
        

        for (int i = 0; i < ber; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            arr[0] += 2;
            arr[len - 1] -=2;

            int min = Math.min(a, b) + 1;
            int max = Math.max(a, b) + limit;

            arr[min]--;
            arr[max + 1]++;

            arr[a + b]--;
            arr[a + b + 1]++;
        }

        int result = Integer.MAX_VALUE;
        int[] arr2 = new int[len];

        for (int j = 0; j < len; j++) {
            

          
            if (j == 0) {
                arr2[j] = arr[j];
            } else {
                arr2[j] = arr2[j - 1] + arr[j];
            }

            if (j >= 2 && j <= 2 * limit) {
                result = Math.min(result, arr2[j]);
            }
        }

        return result;
    }
}