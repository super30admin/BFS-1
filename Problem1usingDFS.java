// Time Complexity :O(n)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode : Yes
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

 //using BFS
 class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        this.result = new ArrayList<>();
        if(root == null) return result;
        helper(root,0);
        return result;

    }

    private void helper(TreeNode root, int level){
        //base
         if(root == null) return;

        //logic
        //preorder
        if(result.size() == level){
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        helper(root.left,level + 1);
        helper(root.right,level + 1);
    }
}