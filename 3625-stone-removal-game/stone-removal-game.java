class Solution {
    public boolean canAliceWin(int n) {
        if(n<10)return false;
        int ali = 10;
        while(n>=0){
           if(n<ali){
            return ali%2!=0;
           }
             n-=ali;
             ali--;
        }
       return false;
    }
}