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
    public int sumRootToLeaf(TreeNode root) {
        return rootsum(root,0);
    }
    public int rootsum(TreeNode root,int val){
        if(root == null)return 0;
        val = val*2+root.val;
        if(root.left==null && root.right == null) return val;
        return rootsum(root.left,val) + rootsum(root.right,val);
    }
}