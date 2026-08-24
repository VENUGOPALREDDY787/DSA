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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> Qu = new LinkedList<>();
        if(root == null)return ans;
        Qu.add(root);
        while(!Qu.isEmpty()){
            int size = Qu.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i<size;i++){
                TreeNode node = Qu.poll();
                list.add(node.val);
                if(node.left!=null){
                    Qu.offer(node.left);
                }
                if(node.right!=null){
                    Qu.offer(node.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}