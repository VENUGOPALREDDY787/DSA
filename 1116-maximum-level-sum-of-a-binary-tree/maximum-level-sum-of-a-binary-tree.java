
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);

        int level = 0;
        int max = Integer.MIN_VALUE;
        int maxLevel = 0;

        while (!Q.isEmpty()) {
            int size = Q.size();
            int sum = 0;
            level++;

            for (int i = 0; i < size; i++) {
                TreeNode now = Q.poll();
                sum += now.val;

                if (now.left != null) {
                    Q.add(now.left);
                }

                if (now.right != null) {
                    Q.add(now.right);
                }
            }

            if (max < sum) {
                maxLevel = level;
                max = sum;
            }
        }

        return maxLevel;
    }
}
