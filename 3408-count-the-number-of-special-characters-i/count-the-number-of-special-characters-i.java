class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> low = new HashSet<>();
        HashSet<Character> high = new HashSet<>();
        int x =0;
        for(char a: word.toCharArray()){
            if(Character.isLowerCase(a)) low.add(a);
            else{high.add(Character.toLowerCase(a));}
        }
        for(char a :low){
            if(high.contains(a))x++;
        }
    return x;
    }
}