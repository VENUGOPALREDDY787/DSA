class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> al=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        func(al,li,target,candidates,0);
        return al;

    }
    public static void func(List<List<Integer>> al,List<Integer> li,int target,int[] candidates,int indx){
        if(target==0){
            al.add(new ArrayList<>(li));
            return;
        }
        for(int i=indx;i<candidates.length;i++){
            if(candidates[i]<=target){
                li.add(candidates[i]);
                func(al,li,target-candidates[i],candidates,i);
                li.remove(li.size()-1);
            }
        }


    }
}