class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean ispossipble = false;
        int evencount = 0;
        int oddcount = 0;
        
        for(int i = 0; i< nums1.length;i++){
            if(nums1[i]%2 == 0){
                evencount++;
            }else{
                oddcount++;
            }
        }
        if((evencount == 0 ||oddcount == 0) || (evencount>0) ){
            ispossipble = true;
        }
        return ispossipble;
    }
}