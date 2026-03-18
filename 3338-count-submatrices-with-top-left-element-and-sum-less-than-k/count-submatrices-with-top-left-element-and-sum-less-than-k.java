class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int count = 0;
        int[] arr = new int[grid[0].length];
        for(int i = 0 ; i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                arr[j]+=grid[i][j];
            }int sum = 0;
            for(int j = 0;j<arr.length;j++){
                sum+=arr[j];
                if(sum<=k)count++;
                else break;
            }
        }
        return count;
    }
}