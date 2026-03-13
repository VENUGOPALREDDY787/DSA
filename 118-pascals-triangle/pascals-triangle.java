class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> MainList = new ArrayList<>();
        for(int i = 0; i <numRows;i++){
            List<Integer> New = new ArrayList<>();
            for(int j =0;j<= i;j++){
                if(j==0 || j==i){
                    New.add(1);
                }else{
                    int top = MainList.get(i-1).get(j);
                    int topLeft = MainList.get(i-1).get(j-1);
                    New.add(top+topLeft);
                }
            }
            MainList.add(New);
        }
        return MainList;
    }
}