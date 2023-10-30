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

/* Time Complexity : O(n) 
 *  n - length of the tree */
/* Space Complexity : O(h)
 *  h - height of the tree */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//DSF solution

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int level){
        //base case
        if(root == null) return;

        //logic
        //If level equals length of the result => list is not present at index 'level'
        //create an empty list
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        //add root value to the newly created or existing list
        result.get(level).add(root.val);

        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}