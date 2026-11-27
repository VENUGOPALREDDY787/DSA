class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] copies = new int[n]; //copies[i] = free copies if I buy ith item
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);

            int copy = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (items[j][0] % items[i][0] == 0)
                    copy++;
            }

            copies[i] = copy;
        }

        int[][] t = new int[n + 1][budget + 1];

        // Base case: no item types left, spend leftover on the cheapest item
        // n = 0
        for (int b = 0; b <= budget; b++)
            t[0][b] = b / minPrice;

        for (int i = 1; i <= n; i++) {
            for (int b = 0; b <= budget; b++) {
                int price = items[i - 1][1];
                int take = 0;

                if (price <= b)
                    take = 1 + copies[i - 1] + t[i - 1][b - price];

                int skip = t[i - 1][b];

                t[i][b] = Math.max(take, skip);
            }
        }

        return t[n][budget];
    }
}