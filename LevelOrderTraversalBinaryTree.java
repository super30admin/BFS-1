// TC - O(n)
// SC - O(h) but in worst case if we have skew tree then it will be O(n)

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversalBinaryTree {

    public static class TreeNode {
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

    // DFS Approach
    static class Solution {
        List<List<Integer>> result;
        public List<List<Integer>> levelOrder(TreeNode root) {
            result = new ArrayList<>();
            if (root==null) return result;
            dfs(root,0);
            return result;
        }

        private void dfs(TreeNode root, int depth) {
            // base
            if (root==null) return;

            // logic
            if (depth == result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(depth).add(root.val);
            dfs(root.left,depth+1);
            dfs(root.right,depth+1);
        }
    }
}
