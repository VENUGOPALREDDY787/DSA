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
     Integer prev=null;
    int mindiff = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        findminvalues(root);
        return mindiff;
    }
    public void findminvalues(TreeNode root){
        if(root==null){
            return;
        }
        findminvalues(root.left);
        if(prev!=null){
            mindiff = Math.min(mindiff,root.val-prev);
        }
        prev = root.val;
        
        findminvalues(root.right);

    }
}