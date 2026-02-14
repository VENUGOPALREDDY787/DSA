class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        double[][] value = new double[102][102];
        value[0][0] = poured;
        for(int i =0;i<=query_row;i++){
            for(int j =0; j<=i;j++){
               if(value[i][j]>1){
                double excess = value[i][j]-1;
                value[i][j]=1;
                value[i+1][j] += excess/2;
                value[i+1][j+1] += excess/2;
               }
            }
        } 
        return value[query_row][query_glass]; 
         }
}