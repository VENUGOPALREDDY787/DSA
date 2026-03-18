class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] histgraph = new int[matrix.length][matrix[0].length];
        for(int j = 0 ;j < matrix[0].length;j++){
            int sum = 0;
            for(int i = 0 ; i< matrix.length;i++){ 
                if(matrix[i][j] =='1'){
                    sum++;
                }else{
                    sum = 0;
                }
                histgraph[i][j] = sum;
            }
        }
    Stack<Integer> s = new Stack<>();
    int maxarea = 0;
    for(int i = 0 ; i<histgraph.length;i++){
        s.clear();
        for(int j = 0 ; j<=histgraph[0].length;j++){
            int h = (j == histgraph[0].length)?0:histgraph[i][j];
             while(!s.isEmpty() && h <histgraph[i][s.peek()]){
                int height = histgraph[i][s.pop()];
                int width = s.isEmpty()?j:j-s.peek()-1;   
                maxarea = Math.max(maxarea,height*width);
             }
             s.push(j);
        }

    }
    return maxarea;
    }
}