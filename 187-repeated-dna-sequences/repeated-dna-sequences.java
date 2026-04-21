class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> first = new HashSet<>();
        HashSet<String> second = new HashSet<>();
        for(int i = 0;i<=s.length()-10;i++){
            String part = s.substring(i,i+10);
            if(first.contains(part)){
                second.add(part);
            }else{
                first.add(part);
            }
        }
        return new ArrayList<>(second);
    }
}