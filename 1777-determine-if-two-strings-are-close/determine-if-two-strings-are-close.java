class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n!=m)return false;
        int[] word1arr = new int[26];
        int[] word2arr = new int[26];
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i<n;i++){
           word1arr[word1.charAt(i)-'a']++;
           word2arr[word2.charAt(i)-'a']++;
           set.add(word1.charAt(i));
           
        }
        Arrays.sort(word1arr);
        Arrays.sort(word2arr);
        if(!Arrays.equals(word1arr,word2arr))return false;
        for(int i = 0; i<n;i++){
            if(!set.contains(word2.charAt(i)))return false;
        }
        return true;
    }
}