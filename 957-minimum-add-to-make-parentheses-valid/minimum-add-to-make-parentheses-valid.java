class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> S = new Stack<>();

        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
          
            if(ch == '('){
                S.push(ch);
            }else{
                if(!S.isEmpty() &&S.peek() == '('){
                    S.pop();
                }else{
                    S.push(ch);
                }
            }
        }
        return S.size();
    }
}