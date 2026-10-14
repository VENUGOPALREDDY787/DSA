class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        if(n<k)return -1;
        int count = 0;
        for(int i = 0; i< k;i++){
            if(isvol(s.charAt(i))){
                count ++;
            }
        }
        int max = count ;
        for(int i = k; i< n;i++){
            if(isvol(s.charAt(i))){
                count ++;
            }
            if(isvol(s.charAt(i-k))){
                count--;
            }
            max = Math.max(max,count);
        }
        return max;

    }
    public static boolean isvol(char ch){
        if(ch =='a' ||ch =='e'||ch == 'i'||ch =='o'||ch =='u') return true;
        return false;
    }
}