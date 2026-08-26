class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {

            int size = q.size();
            Deque<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                if (leftToRight)
                    level.addLast(node.val);
                else
                    level.addFirst(node.val);

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);
            }

            ans.add(new ArrayList<>(level));

            leftToRight = !leftToRight;
        }

        return ans;
    }
}