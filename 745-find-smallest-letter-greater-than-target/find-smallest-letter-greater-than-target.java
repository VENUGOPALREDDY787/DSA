class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
   
    char index = letters[0];
      for(int i = 0; i<letters.length;i++){
       
            if(target<letters[i]){
                // flag = true;
                index = letters[i];
                break;

        }
      }
     return index;
    }
}