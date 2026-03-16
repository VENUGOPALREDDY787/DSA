class Solution {

    static int[] values = new int[3];

    public int[] getBiggestThree(int[][] grid) {

        for (int i = 0; i < 3; i++) {
            values[i] = 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int maxsize = Math.min(i, Math.min(j, Math.min(n - 1 - i, m - j - 1)));

                if (maxsize == 0) {
                    arrange(grid[i][j]);
                }

                for (int k = 1; k <= maxsize; k++) {
                    int val = findsum(i, j, k, grid);
                    arrange(val);
                }
            }
        }

        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (values[i] != 0) {
                count++;
            }
        }

        int[] ans = new int[count];

        for (int i = 0; i < count; i++) {
            ans[i] = values[i];
        }

        return ans;
    }

    public static int findsum(int i, int j, int k, int[][] grid) {

        int sum = 0;

        int top = i - k;
        int bottom = i + k;

        // top half
        for (int l = 0; l <= k; l++) {

            if (l == 0) {
                sum += grid[top][j];
            } 
            else {
                sum += grid[top + l][j - l] + grid[top + l][j + l];
            }
        }

        // bottom half
        for (int l = 1; l < k; l++) {
            sum += grid[bottom - l][j - l] + grid[bottom - l][j + l];
        }

        sum += grid[bottom][j];

        return sum;
    }

    public static void arrange(int val) {

        // avoid duplicates
        for (int i = 0; i < 3; i++) {
            if (values[i] == val) {
                return;
            }
        }

        // maintain top 3 values
        for (int i = 0; i < 3; i++) {

            if (val > values[i]) {

                for (int j = 2; j > i; j--) {
                    values[j] = values[j - 1];
                }

                values[i] = val;
                break;
            }
        }
    }
}