class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < (long)m * k)
            return -1;
        int high = (int) 1e9;
        int low = 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canpossable(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean canpossable(int[] bloomDay, int m, int k, int day) {
        int total = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            int count = 0;
            while (i < bloomDay.length && bloomDay[i] <=day && count < k) {
                count++;
                i++;
            }
            if (count == k) {
                total++;
                i--;
            }
            
            if (total >= m) return true;
        }
        return false;
    }
}





