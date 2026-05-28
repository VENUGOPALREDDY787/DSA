class Solution {
    static long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long count = 1;
        count=(power(5,(n+1)/2)*power(4,n/2))%MOD;
        
        
        return (int)count;
    }
    public static long power(long x ,long n){
        long ans = 1;
        while(n>0){
            if(n%2!=0){
                ans=(ans*x)%MOD;
            }
            x=(x*x)%MOD;
            n = n/2;
        }
        return ans;
    }
}