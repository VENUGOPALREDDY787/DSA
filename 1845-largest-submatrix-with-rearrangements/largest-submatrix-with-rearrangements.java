class Solution {
    public int largestSubmatrix(int[][] matrix) {
    int[] arr = new int[matrix[0].length];
    int max = 0;
       for(int i =0 ;i <matrix.length;i++ ){
        for(int j = 0;j<matrix[0].length;j++){
            if(matrix[i][j] ==1)arr[j]++;
            else arr[j] = 0;
        }
        int[] clo = arr.clone();
        Arrays.sort(clo);
        for(int j = matrix[0].length-1;j>=0;j--){
            if(clo[j] == 0) break;
            max = Math.max(max,clo[j]*(matrix[0].length-j));
        }
       }
       return max;
    }
}