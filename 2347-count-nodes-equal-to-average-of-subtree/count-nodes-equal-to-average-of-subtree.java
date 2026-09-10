class Solution {

    class Info {
        int sum;
        int n;

        Info(int sum, int n) {
            this.sum = sum;
            this.n = n;
        }
    }

    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return count;
    }

    public Info helper(TreeNode root) {

        if (root == null) {
            return new Info(0, 0);
        }

        Info left = helper(root.left);
        Info right = helper(root.right);

        int sum = left.sum + right.sum + root.val;
        int n = left.n + right.n + 1;

        
        int average = sum / n;

        if (average == root.val) {
            count++;
        }

        return new Info(sum, n);
    }
}