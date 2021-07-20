// 102. Binary Tree Level Order Traversal - https://leetcode.com/problems/binary-tree-level-order-traversal/
// Time Complexity : O(N)
// Space Complexity : O(k) where k is max no of level nodes 
// Did it run on leetcode? : Yes
// Any problems faced? : No

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
        result = new ArrayList<List<Integer>>();
        // base
        if(root==null)
            return result;
        
        dfs(root,0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        // base
        if(root == null) return;
        // logic
        if(result.size()==level)
            result.add(new ArrayList<>());
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}