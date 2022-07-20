import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.TreeNode;

// Time Complexity : O(n)  
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        result = new ArrayList<>();
        dfs(root, 0); // performing level order traversal(BFS) using DFS.
        return result;

    }

    private void dfs(TreeNode root, int level) {
        // base case
        if (root == null)
            return;
        // logic
        if (level == result.size()) {
            result.add(new ArrayList<>()); // if level==list.size(), then add a new list at that index.
        }
        result.get(level).add(root.val); // adding the root value to the list at the same level.
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);

    }
}