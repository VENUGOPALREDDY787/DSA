class Solution {

    static int MOD = 1000000007;

    public int concatenatedBinary(int n) {
        return calculateCount(n, 1, 0);
    }

    public static int calculateCount(int n, int m, int count){

        if(m > n){
            return count;
        }

        int length = 32 - Integer.numberOfLeadingZeros(m);

        count = (int)(((long)count << length | m) % MOD);

        return calculateCount(n, m + 1, count);
    }
}