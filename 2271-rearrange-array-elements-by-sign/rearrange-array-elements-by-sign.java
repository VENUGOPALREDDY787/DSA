class Solution {
    public int[] rearrangeArray(int[] nums) {
        int evenarr[] = new int[nums.length/2];
        int oddarr[] = new int[nums.length/2];
        
        int even = 0;
        int odd = 0;

        // separate positives and negatives
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                evenarr[even] = nums[i];
                even++;
            }else{
                oddarr[odd] = nums[i];
                odd++;
            }
        }

        // merge alternately
        int arr[] = new int[nums.length];
        int i = 0;
        int k = 0;

        while(i < evenarr.length){
            arr[k] = evenarr[i];
            k++;
            arr[k] = oddarr[i];
            k++;
            i++;
        }

        return arr;
    }
}
