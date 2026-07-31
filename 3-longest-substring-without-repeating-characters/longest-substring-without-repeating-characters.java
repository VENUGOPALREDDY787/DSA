class Solution {
    public int lengthOfLongestSubstring(String s) {
      HashSet<Character> set = new HashSet<>();
      int i  = 0;
      int j = 0;
      int max = 0;
      while(j<s.length()){
        char ch = s.charAt(j);
        if(set.contains(ch)){
             set.remove(s.charAt(i));
            i++;
           
        }else{
        set.add(ch);
        max= Math.max(max,j-i+1);
        j++;
        }
      }
      return max;
    }
}
