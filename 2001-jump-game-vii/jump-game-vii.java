class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n-1)=='1')return false;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int maxreach = 0;
        while(!q.isEmpty()){
            int i = q.remove();
            if(i== n-1)return true;
            for(int j = Math.max(i+minJump,maxreach);j<=Math.min(i+maxJump,n-1);j++){
                if(s.charAt(j) =='0'){
                    q.add(j);
                }
            }
            maxreach = Math.min(i+maxJump+1,n-1);
        }
        return false;
    }
}