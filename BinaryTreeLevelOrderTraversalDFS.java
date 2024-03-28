Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
// Time Complexity : O(n) where 'n' is the number of nodes in the tree.
// Space Complexity : O(n/2) i.e. O(n).
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/binary-tree-level-order-traversal/
// Any problem you faced while coding this : No

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
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root==null) return result;
        helper(root,0);
        return result;
    }

    public void helper(TreeNode root, int level){
        if(root==null) return;

        if(result.size()==level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}
