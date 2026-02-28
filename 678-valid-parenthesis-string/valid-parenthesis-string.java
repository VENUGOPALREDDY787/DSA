class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openparanthis = new Stack<>();
        Stack<Integer> asters = new Stack<>();
        for(int i =0 ; i< s.length();i++){
            if(s.charAt(i)== '('){
                openparanthis.push(i);
            }else if(s.charAt(i)=='*'){
                asters.push(i);
            }else{
                if(!openparanthis.isEmpty()){
                    openparanthis.pop();
                }else if(!asters.isEmpty()){
                    asters.pop();
                }
                else{
                    return false;
                }
            }
        }
        while(!openparanthis.isEmpty()){
            if(asters.isEmpty())return false;
            if(openparanthis.pop()>asters.pop()){
                return false;
            }
        }
        return openparanthis.isEmpty();
    }
}