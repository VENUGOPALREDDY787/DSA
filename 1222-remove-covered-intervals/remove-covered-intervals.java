class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> b[0] - a[0]);

        int n = intervals.length;
        int count = n;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (intervals[i][1]<=intervals[j][1]) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }
}