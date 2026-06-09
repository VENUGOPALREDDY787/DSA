class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ml = new ArrayList<>();
        helper(s,0,ml,new ArrayList<>());
        return ml;
    }
    public static void helper(String s ,int index ,List<List<String>> ml,List<String> li){
        if(index == s.length()){
            ml.add(new ArrayList<>(li));
        }
        for(int i = index;i<s.length();i++){
            if(ispalandeoma(s,index,i)){
                li.add(s.substring(index,i+1));
                helper(s,i+1,ml,li);
                li.remove(li.size()-1);
            }
        }
    }
    public static boolean ispalandeoma(String s , int start , int end){
        if(start== end){
            return true;
        }
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
            return false;}
            start++;
            end--;
        }
        return true;
    }
}