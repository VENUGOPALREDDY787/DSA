class Solution {
    
    public List<String> generateValidStrings(int n, int k) {
        List<String> result = new ArrayList<>();
        for(int i = 0 ; i<(1 << n);i++){
            String now = isvalied(i,k,n);
            if(now != ""){
                result.add(now);
            }
        }
        return result;
    }
    public static String isvalied(int num,int k,int n){
        String result = "";
        int count = 0;
        int prev = 0;
        
        while(n>0){ 
             if(prev== 1 && (num&1) == 1)return "";
            if((num & 1) == 0){
                result = '0'+result;
                prev = 0;
                
            }else{
                result = '1'+result;
                prev = 1;
                count+=(n-1);
            }
            if(count>k)return "";
            num =num>>1;
            n--;


        }
        return result;
    }
}