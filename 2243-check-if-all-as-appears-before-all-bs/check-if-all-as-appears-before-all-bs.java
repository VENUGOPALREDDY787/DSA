class Solution {
    public boolean checkString(String s) {
        boolean bstart = false;
          for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'a' && bstart)return false;
            if(ch =='b'){
                bstart = true;
            }
          }
          return true;
    }
}