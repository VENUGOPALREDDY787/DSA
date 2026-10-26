/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int ans = 0;
    public int longestZigZag(TreeNode root) {
        ans = 0;
        maxZigZag(root,true,0);
        maxZigZag(root,false,0);
        return ans;
    }
    public static void maxZigZag(TreeNode root, boolean isLeft,int len){
       if(root == null) return;
       ans = Math.max(ans,len);
       if(isLeft){
        maxZigZag(root.left,false,len+1);
        maxZigZag(root.right,true,1);
       }else{
        maxZigZag(root.right,true,len+1);
        maxZigZag(root.left,false,1);
       }
    }
}