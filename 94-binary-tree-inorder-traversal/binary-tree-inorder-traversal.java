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
    

    public List<Integer> inorderTraversal(TreeNode root) {
     ArrayList List = new ArrayList<>();
     inorder(root,List);
     return List;
    }
    public static void inorder(TreeNode root,ArrayList<Integer> List){
        if(root == null){
            return;
        }
        inorder(root.left,List);
        List.add(root.val);
        inorder(root.right,List);
    }
}