class Solution {
    public int minInsertions(String s) {
        int count = 0;
        int left = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '('){
                left++;
            }else{
                if(i+1<s.length() && s.charAt(i+1) == ')'){
                    i++;
                }else{
                    count++;
                }
                if(left>0){
                    left--;
                }else{
                    count++;
                }
            }
        }
        return count+=left*2;
    }
}