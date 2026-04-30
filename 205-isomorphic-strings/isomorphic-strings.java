class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] maps = new int[256];
        int[] mapt = new int[256];
        for(int i = 0; i<s.length();i++){
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if(maps[chs]!=mapt[cht]){
                return false;
            }
            maps[chs]=i+1;
            mapt[cht] = i+1;
        }
        return true;
    }
}