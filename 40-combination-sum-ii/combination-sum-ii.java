class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> al=new ArrayList<>();
         List<Integer> li=new ArrayList<>();
         Arrays.sort(candidates);
        hellper(al,li,candidates,0,target);
        return al;
    }
    public static void hellper(List<List<Integer>> al, List<Integer> li, int[] candidates,int idx,int target){
        if(target==0){
            al.add(new ArrayList<>(li));
            return;
        }
        for(int i =idx;i<candidates.length;i++){
             if(i>idx && candidates[i]==candidates[i-1]){
                continue;
             }if(candidates[i]>target)break;
            li.add(candidates[i]);
            hellper(al,li,candidates,i+1,target-candidates[i]);
            li.remove(li.size()-1);
             }
        }
    
}