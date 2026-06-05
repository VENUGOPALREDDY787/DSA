class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        List<String> list = new ArrayList<>();
        helper(digits,0,list,"",map);
        return list;
    }
    public static void helper(String digits,int idx , List<String> list, String res,HashMap<Integer,String> map ){
        if(idx == digits.length()){
            list.add(res);
            return;
        } 
        int num = digits.charAt(idx)-'0';
        String values = map.get(num);
        for(int i = 0; i< values.length();i++){
            helper(digits,idx+1,list,res+values.charAt(i),map);
        }

    }
}