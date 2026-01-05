class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int currcost =0;
        int start=0;
        int totalgas = 0;
        int totalcost =0;
        for(int i =0;i<n;i++){
            totalgas+=gas[i];
            totalcost+=cost[i];
        }
        if(totalcost>totalgas){
            return -1;
        }
        for(int i=0;i<n;i++ ){
            currcost += gas[i]-cost[i];
            if(currcost<0){
                currcost=0;
                start=i+1;
            }
        }
    return start;
    }
}