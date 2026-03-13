class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        List<int []> arrlist = new ArrayList<>();
        int [] prev = intervals[0];
        for(int i = 1;i< intervals.length;i++){
            int[] interval = intervals[i];
            if(interval[0]<=prev[1]){
                prev[1] = Math.max(prev[1],interval[1]);
            }else{
                arrlist.add(prev);
                prev = interval;
            }
        }
        arrlist.add(prev);
        return arrlist.toArray(new int [0][]);
    }
}