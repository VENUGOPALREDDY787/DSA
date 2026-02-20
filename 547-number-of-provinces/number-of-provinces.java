class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis = new boolean[isConnected.length];
        int count =0;

        for(int i =0;i<isConnected.length;i++){
            if(!vis[i]){
                dsfinit(isConnected,vis,i);
                count++;
            }
        }
        return count;
    }
    public static void dsfinit(int[][] isConnected,boolean[] vis,int curr){
            vis[curr]=true;
            for(int j =0; j<isConnected.length;j++){
                if(isConnected[curr][j] ==1 && !vis[j]){
                dsfinit(isConnected,vis,j);
                }
            }
    }
}