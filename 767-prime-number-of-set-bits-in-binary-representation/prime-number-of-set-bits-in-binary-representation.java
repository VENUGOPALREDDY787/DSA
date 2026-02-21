class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        HashSet<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(11);
        set.add(13);
        set.add(17);
        set.add(19);
        for(int i = left;i<=right;i++){
            if(set.contains(iscount(i))){
                count+=1;
            }
        }
        return count;
    }
    public static int iscount(int i){
        int count = 0;
        while(i!=0){
            count+=(i&1);
            i>>=1;
        }
        return count;
    } 
}