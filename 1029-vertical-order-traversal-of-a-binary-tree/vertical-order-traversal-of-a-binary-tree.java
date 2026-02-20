import java.util.*;

class Solution {
    static class Node {
        int col, row, val;
        Node(int c, int r, int v) {
            col = c;
            row = r;
            val = v;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Node> list = new ArrayList<>();
        dfs(root, 0, 0, list);

        // sort by column, then row, then value
        Collections.sort(list, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.val - b.val;
        });

        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for (Node n : list) {
            if (n.col != prevCol) {
                result.add(new ArrayList<>());
                prevCol = n.col;
            }
            result.get(result.size() - 1).add(n.val);
        }
        return result;
    }

    private void dfs(TreeNode root, int row, int col, List<Node> list) {
        if (root == null) return;
        list.add(new Node(col, row, root.val));
        dfs(root.left, row + 1, col - 1, list);
        dfs(root.right, row + 1, col + 1, list);
    }
}