class Solution {
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int si = 0;
        int ei = mountainArr.length() - 1;
        int lastindex = ei;
        int peakindex = 0;
        int minval = -1;

        // Find peak index
        while(si < ei){
            int mid = si + (ei - si) / 2;

            if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
                si = mid + 1;
            } else {
                ei = mid;
            }
        }

        peakindex = si;

        // Search in increasing part
        si = 0;
        ei = peakindex;

        while(si <= ei){
            int mid = si + (ei - si) / 2;

            if(mountainArr.get(mid) == target){
                minval = mid;
                break;
            } else if(mountainArr.get(mid) < target){
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        if(minval != -1) return minval;

        // Search in decreasing part
        si = peakindex + 1;
        ei = lastindex;

        while(si <= ei){
            int mid = si + (ei - si) / 2;

            if(mountainArr.get(mid) == target){
                minval = mid;
                break;
            } else if(mountainArr.get(mid) < target){
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return minval;
    }
}