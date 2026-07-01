import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /* 
        TC - O(N)
        SC - O(N)
        This solution performs a level-order traversal of the binary tree using DFS (recursion).
        Starting from the root at level 0, it recursively visits each node. If a level is being visited for the first time,
         a new list is created for that level. The current node's value is added to the list corresponding to its level.
        The recursion then continues with the left and right children, increasing the level by 1.
        After all nodes are visited, result contains the values of the tree level by level.
    */
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        // TC - O(n)
        // SC - O(n) (recursion stack uses O(h) space)
        if (root == null) return result;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode node, int level) {
        if (node == null) return;

        if (level == result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);
        helper(node.left, level + 1);
        helper(node.right, level + 1);
    }
}