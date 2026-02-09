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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> nums = new ArrayList<>();
        inorder(root,nums);

        return balanceTree(nums,0,nums.size()-1);
    }
    public static void inorder(TreeNode root,ArrayList<Integer> nums){
        if(root == null) return;
        inorder(root.left,nums);
        nums.add(root.val);
        inorder(root.right,nums);
    }
    public static TreeNode balanceTree(ArrayList<Integer> nums,int ls ,int rs){
        if(ls>rs)return null;
        int mid =ls+(rs-ls)/2;
        TreeNode node = new TreeNode(nums.get(mid));
        node.left = balanceTree(nums,ls,mid-1);
        node.right = balanceTree(nums,mid+1,rs);
        return node;
    }
}