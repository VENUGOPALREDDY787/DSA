class Solution {
    public int compress(char[] chars) {
     int i = 1;
     int count = 1;
     int ans=0;

    String s1 = "";
     while(i<=chars.length-1){
        if(chars[i]==chars[i-1]){
            count++;
            i++;
        }else{
            chars[ans++] = chars[i-1];
            if(count>1){
            for (char c : String.valueOf(count).toCharArray()) {
                chars[ans++] = c;
            }}
            count=1;
            i++;    
        }}
            chars[ans++] = chars[i-1];
            if(count>1){
            for (char c : String.valueOf(count).toCharArray()) {
                chars[ans++] = c;
            }}
         
        return ans;
     }
    
}