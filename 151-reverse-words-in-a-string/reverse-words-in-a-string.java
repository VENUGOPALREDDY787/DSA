class Solution {
    public String reverseWords(String s) {
        StringBuilder m =new StringBuilder();
        StringBuilder Ss =new StringBuilder();
        for(int i =s.length()-1; i>=0;i--){
            if(s.charAt(i) == ' '){
                if(Ss.length()>0)
                    m.append(Ss.reverse()).append(" ");               
                Ss.setLength(0);
            }
            else{
                Ss.append(s.charAt(i));
            }
        }
        if(Ss.length()>0){
            m.append(Ss.reverse()).append(" "); 
        }
        return m.toString().trim();
    }
}