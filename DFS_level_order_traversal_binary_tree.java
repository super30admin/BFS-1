// Time Complexity : O(n), where n is the number of nodes
// Space Complexity : O(n), where n is the height of the tree (space required for the recursive stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explanation in plain english
//1. Create a List of lists (result )to return the result, start the DFS from the root and maintain a local variable to count level at each node
//2. level starting at 0, check at each node if the level is equal to the size of the result, if yes create a new arraylist inside
        //the result (to store all the nodes at that level), and add the current node's value in the new created list
//3. If level is not equal to the size of the result, that means we already have an inner list for that level in the result, so simply
        //add the current's node value to inner list at the level in the result. Continue doing this to complete the tree

// Your code here along with comments explaining your approach

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
        //for returning the result
        result = new ArrayList<>();
        
        dfs(root, 0);
        //return the list of lists
         return result;
    }
    private void dfs(TreeNode root, int level){
        //base
        if(root == null) return;
        //logic
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        
        //explore left subtree
        dfs(root.left, level+1);
        //stack.pop()
        //go to the right child
        dfs(root.right, level+1);
    }
}