class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int largestprefix = 0;
        HashSet<Integer> setA = new HashSet<>();
        for(int i = 0; i< arr1.length;i++){
            int a = arr1[i];
            while(a>0){
                if(setA.contains(a))break;
                setA.add(a);
                a=a/10;
            }
        }
       for(int i = 0; i<arr2.length;i++){
        int b  = arr2[i];
        while(b>0){
            if(setA.contains(b) && largestprefix <b){
                    largestprefix = b;
                    break;
            }
            b=b/10;
        }
       }
       int count = 0;
       while(largestprefix>0){
        count++;
        largestprefix= largestprefix/10;
       }
       return count;
    }
}