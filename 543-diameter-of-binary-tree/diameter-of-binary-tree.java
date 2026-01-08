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
    public int height(TreeNode root){
        if(root == null)return 0;
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        int height = Math.max(leftheight,rightheight);
        return height+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftdia= diameterOfBinaryTree(root.left);
        int rightdia= diameterOfBinaryTree(root.right);
        int leftheight=height(root.left);
        int rightheight=height(root.right);
        int selfdia=leftheight+rightheight;
        return Math.max(selfdia,Math.max(leftdia, rightdia)); 
    }
}