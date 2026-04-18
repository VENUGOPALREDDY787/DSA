class Solution {
    public int shipWithinDays(int[] weights, int days) {
int si =0;
int ei =0;
    for(int i =0;i<weights.length;i++){
        si= Math.max(si,weights[i]);
       ei +=weights[i];
    }
    while(si<ei){
        int mid = si+(ei-si)/2;
        if(find(weights,mid)<days){
            ei = mid;
        }else{
            si= mid+1;
        }
    }
    return si;
    }
    public int find(int[] weights,int weight){
        int days = 0;
        int curr =0;
        for(int i =0 ;i< weights.length;i++){
            if(curr + weights[i]>weight){
                days++;
                curr = 0;
            }
            curr += weights[i];
        }
        return days;
    }
}