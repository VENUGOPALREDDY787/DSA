class Solution {
    public boolean isValid(String s) {
        Stack<Character> S = new Stack<>();
        if(s.length()==1) return false;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch =='[' || ch=='{'){
                S.push(ch);
            }
            else{
                if(S.isEmpty()){
                    return false;
                }
                if(
                (ch==')' && S.peek()=='(')||
                (ch=='}' && S.peek()== '{')||
                (ch==']' && S.peek()=='[')){
                    S.pop();
                }
                else{
                    return false;
                }
            }
        }
     return S.isEmpty();
    }
}