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
    static int count = 0;
    public int goodNodes(TreeNode root) {
        if(root == null )return 0;
        count = 1;
       dfs(root.left, root.val);
       dfs(root.right,root.val);
       return count ;
    }
    public void dfs(TreeNode root , int val){
        if(root == null)return ;
        int max = Math.max(val,root.val);
        if(max<=root.val){
            count++;
        }
        dfs(root.left,max);
        dfs(root.right,max);
    }
}