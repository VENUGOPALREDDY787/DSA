class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int si = 0;
        int ei = mat[0].length-1;
        while(si<=ei){
            int mid = si+(ei-si)/2;
            int maxrow = 0;
            for(int i = 0;i< mat.length;i++){
                if(mat[i][mid]>mat[maxrow][mid]){
                    maxrow = i;
                }
            }
            int leftval = (mid<=0)?-1:mat[maxrow][mid-1];
            int rightval =(mid>=mat[0].length-1)?-1:mat[maxrow][mid+1];
            if(mat[maxrow][mid]>leftval && mat[maxrow][mid]>rightval){
                return new int[]{maxrow,mid};
            }else if(leftval>mat[maxrow][mid]){
                ei=mid-1;
            }else{
                si = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}