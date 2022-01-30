import java.util.ArrayList;
import java.util.List;

// TC O(N)
// SC O(N)
public class LevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> res;

    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        level = level + 1;
        helper(root.left, level);
        helper(root.right, level);
    }
}
