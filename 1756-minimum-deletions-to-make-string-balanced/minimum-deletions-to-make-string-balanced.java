class Solution {
    public int minimumDeletions(String s) {
        int countofb =0;
        int numberofdeletions = 0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='b'){
                countofb++;
            }else if(countofb>0){
                numberofdeletions++;
                countofb--;
            }
        }
        return numberofdeletions;
    }
}