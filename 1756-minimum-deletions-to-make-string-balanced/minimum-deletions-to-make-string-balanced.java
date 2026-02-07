class Solution {
    public int minimumDeletions(String s) {
        Stack<Character>S = new Stack<>();
        int count = 0;
       for(int i =0;i<s.length();i++){
            if(!S.isEmpty() && S.peek()=='b' && s.charAt(i)=='a'){
                S.pop();
                count++;
            }else{
                S.push(s.charAt(i));
            }
       }
       return count; 
    }
}