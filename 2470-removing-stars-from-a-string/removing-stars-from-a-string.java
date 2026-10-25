class Solution {
    public String removeStars(String s) {
        Stack<Character> S = new Stack<>();
        for(int i = 0; i< s.length();i++){
            char ch = s.charAt(i);
            if(ch != '*'){
                S.push(ch);
            }else{
                S.pop();
            }
        }
        StringBuilder sb = new StringBuilder("");
        while(!S.isEmpty()){
            sb.append(S.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}