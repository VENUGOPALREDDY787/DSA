class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n <= 2)
            return n;

        int m = n;
        int bits = 0;

        while (m != 0) {
            m >>= 1;
            bits++;
        }

        return (int) Math.pow(2, bits);
    }
}