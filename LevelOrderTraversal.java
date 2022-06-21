import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(n)
// Space Complexity: O(1) without considering the recursive stack space.

public class LevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (result.size() == level)
            result.add(new ArrayList<Integer>());

        result.get(level).add(root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
