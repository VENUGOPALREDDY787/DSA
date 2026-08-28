class Solution {

    class Info {
        TreeNode node;
        long index;

        public Info(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;

        Queue<Info> nodes = new LinkedList<>();

        // Root starts at index 0
        nodes.add(new Info(root, 0));

        long maxWidth = 0;

        while (!nodes.isEmpty()) {

            int size = nodes.size();

            // Index of first node in this level
            long first = nodes.peek().index;

            long last = first;

            for (int i = 0; i < size; i++) {

                Info now = nodes.poll();

                last = now.index;

                // Left child
                if (now.node.left != null) {
                    nodes.add(
                        new Info(
                            now.node.left,
                            2 * now.index + 1
                        )
                    );
                }

                // Right child
                if (now.node.right != null) {
                    nodes.add(
                        new Info(
                            now.node.right,
                            2 * now.index + 2
                        )
                    );
                }
            }

            // Width of current level
            long width = last - first + 1;

            maxWidth = Math.max(maxWidth, width);
        }

        return (int) maxWidth;
    }
}