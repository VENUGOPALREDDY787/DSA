class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
      int si = 0;
      int ei = letters.length-1;
      if(target>=letters[ei])return letters[si];
      while(si<=ei){
        int mid = si+(ei-si)/2;
        if(target<letters[mid]){
            ei = mid-1;
        }else{
            si = mid+1;
        }
      }
      return letters[si];
    }
}