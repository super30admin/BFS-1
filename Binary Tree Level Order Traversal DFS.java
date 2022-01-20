// Time Complexity : O(n)
// Space Complexity : O(h)
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
class Solution {

    // intialize the result list to be returned
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        // return empty list is tree is empty
        if(root == null) return result;
        
        // call the recursive function
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        //base
        // return if leaf node
        if(root == null) return;
        
        // logic
        // if sub-list corresponding to level does not exist
        // then add a sub-list
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        
        // add the current node's value to the result list corresponding to its level
        result.get(level).add(root.val);
        
        // call the recursive function on the left child
        dfs(root.left, level + 1);

        // st.pop()

        // call the recursive function on the right child
        dfs(root.right, level + 1);
    }
}