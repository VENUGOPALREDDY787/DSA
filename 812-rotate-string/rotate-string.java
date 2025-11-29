class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        for(int i =0;i<s.length();i++){
            if(s.equals(goal)) return true;
                char ch = s.charAt(0);
                s=s.substring(1)+ch; 
        }
         return false;
    }
}