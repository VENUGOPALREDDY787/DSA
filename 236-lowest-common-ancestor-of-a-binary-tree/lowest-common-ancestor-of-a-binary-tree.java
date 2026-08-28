class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayList<TreeNode> pNodes = new ArrayList<>();
        ArrayList<TreeNode> qNodes = new ArrayList<>();

        findParentNodes(pNodes, root, p);
        findParentNodes(qNodes, root, q);

        int i = pNodes.size() - 1;
        int j = qNodes.size() - 1;

        TreeNode lca = root;

        while (i >= 0 && j >= 0) {

            if (pNodes.get(i).val == qNodes.get(j).val) {
                lca = pNodes.get(i);
                i--;
                j--;
            } else {
                break;
            }
        }

        return lca;
    }

    public boolean findParentNodes(
            ArrayList<TreeNode> list,
            TreeNode root,
            TreeNode target) {

        if (root == null) {
            return false;
        }

        // Target found
        if (root == target) {
            list.add(root);
            return true;
        }

        // Search left subtree
        if (findParentNodes(list, root.left, target)) {
            list.add(root);
            return true;
        }

        // Search right subtree
        if (findParentNodes(list, root.right, target)) {
            list.add(root);
            return true;
        }

        return false;
    }
}