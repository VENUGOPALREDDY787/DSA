class Solution {
    public int[] sortArray(int[] nums) {
        meargeSort(nums,0,nums.length-1);
        return nums;
    }
    public static void meargeSort(int[] arr, int si, int ei){
        if(si>=ei){
            return;
        }
        int mid = (ei+si)/2;
        meargeSort(arr ,si ,mid);
        meargeSort(arr ,mid+1,ei);
        mearge(arr,si,mid,ei);
    }
    public static void mearge(int[] arr,int si,int mid,int ei){
        int temp[] = new int[ei-si+1];
        int i =si;
        int j = mid+1;
        int k =0;
        while(i<=mid && j<=ei){
            if(arr[i]<=arr[j]){
                temp[k]=arr[i];
                i++;
                k++;
            }else{
                temp[k]=arr[j];
                k++;
                j++;
            }
        }
        while(i<=mid){
            temp[k]=arr[i];
            i++;
            k++;
        }
        while(j<=ei){
            temp[k]= arr[j];
            j++;
            k++;
        }
        for(int e =0 ,m=si;e<temp.length && m<=ei;e++,m++){
            arr[m]=temp[e];
        }
    }
}