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
    public TreeNode bstFromPreorder(int[] preorder) {
       TreeNode root = new TreeNode(preorder[0]);
       for(int i =1; i<preorder.length;i++){
        add(root,preorder[i]);
       }
        return root;
    }

    public void add(TreeNode root , int num){
      if(root.val<num){
        if(root.right == null){
            TreeNode node = new TreeNode(num);
            root.right = node;
        }
        else{
            add(root.right,num);
        }
      }else{
        if(root.left == null){
            root.left= new TreeNode(num);
        }
        else{
            add(root.left,num);
        }
      }
    }
}