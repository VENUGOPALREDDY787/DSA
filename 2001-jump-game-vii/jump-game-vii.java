class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n-1) == '1')return false;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int min = 0;
        for(int i = 0; i<n;i++){
            if(!dp[i]){
                continue;
            }
                min =Math.max(i+minJump,min);
                int max = Math.min(i+maxJump,n-1);
                for(int j = min; j<=max;j++){
                    if(s.charAt(j) == '0'){
                    dp[j] = true;
                    }
                }
                min = Math.min(max,n-1);
             if(dp[n-1] == true)return true;
        }
       
        return false;
    }
}