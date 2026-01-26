class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> arrlist = new ArrayList<>();
        if(arr.length < 2){
            return arrlist;
        }
        int minAbs=Integer.MAX_VALUE;
        for(int i =1; i <arr.length;i++){
            minAbs=Math.min(minAbs ,Math.abs(arr[i]-arr[i-1]));
        }
        for(int i =1;i<arr.length;i++){
            if(Math.abs(arr[i]-arr[i-1])==minAbs){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                arrlist.add(temp);
            }
        }
        return arrlist;
    }
}