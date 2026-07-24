class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return n;
        }

        int bits = 0;
       

        for(int num :nums){
            bits|=num;
        }

        return bits + 1;
    }
}
