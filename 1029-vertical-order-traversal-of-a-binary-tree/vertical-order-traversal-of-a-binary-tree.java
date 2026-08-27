import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        
        // Step 1: DFS to collect all (col, row, val)
        dfs(root, 0, 0, nodes);

        // Step 2: Sort by col, then row, then value
        nodes.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);     // col
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);     // row
            return Integer.compare(a[2], b[2]);                       // value
        });

        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        // Step 3: Group by column
        for (int[] node : nodes) {
            int col = node[0], val = node[2];
            if (col != prevCol) {
                result.add(new ArrayList<>());
                prevCol = col;
            }
            result.get(result.size() - 1).add(val);
        }

        return result;
    }

  
    private void dfs(TreeNode node, int row, int col, List<int[]> nodes) {
        if (node == null) return;
        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, row + 1, col - 1, nodes);   
        dfs(node.right, row + 1, col + 1, nodes);  
    }
}