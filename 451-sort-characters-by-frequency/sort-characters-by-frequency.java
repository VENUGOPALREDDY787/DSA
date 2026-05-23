class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        char[] arr = s.toCharArray();
        for(char ch: arr){
            freq[ch]++;
        }
        char[] res = new char[s.length()];
        int idx = 0;
        while(idx<s.length()){
            int maxlen =0;
            int maxidx = 0;
            for(int i = 0;i< freq.length;i++){
                if(freq[i]>maxlen){
                    maxlen = freq[i];
                    maxidx = i;
                }
            }
            while(freq[maxidx]>0){
                res[idx++] = (char)maxidx;
                freq[maxidx]--;
            }
        }
        return new String(res);
    }
}