import java.util.ArrayList;
import java.util.List;

//    TC : O(n)
//    Sc : O(h) where h = height of tree
public class Problem1 {
    //* Definition for a binary tree node.
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

    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) return result;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int lvl) {
        //base case
        if (root == null) return;
        //logic
        if (lvl == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(lvl).add(root.val);

        helper(root.left, lvl + 1);
        helper(root.right, lvl + 1);
    }
}
