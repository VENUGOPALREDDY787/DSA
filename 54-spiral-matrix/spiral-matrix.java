class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int firstrow = 0;
        int lastrow = matrix.length-1;
        int firstcol = 0;
        int lastcol = matrix[0].length-1;
        ArrayList<Integer> list = new ArrayList<>(); 
        while(firstrow<=lastrow && firstcol<=lastcol){

        
        for(int i =firstcol;i<=lastcol;i++){
            list.add(matrix[firstrow][i]);
        }
        for(int i =firstrow+1;i<=lastrow;i++){
            list.add(matrix[i][lastcol]);
        }
        for(int i =lastcol-1;i>=firstcol;i--){
            if(firstrow == lastrow){
                break;
            }
            list.add(matrix[lastrow][i]);
        }
        for(int i =lastrow-1;i>firstrow;i--){
            if(firstcol == lastcol){
                break;
            }
            list.add(matrix[i][firstcol]);
        }
        firstrow++;
        firstcol++;
        lastrow--;
        lastcol--;
        }
        return list;
    }
}