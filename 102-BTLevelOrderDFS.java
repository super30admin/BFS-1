/**LC-234
 * Time Complexity : O(N) 
 * Space Complexity : Not sure 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm:
 1. If root == null return result
 2. Created a recursive function dfs which will go till any of the node located at the most depth
 3. At any given node, check the level and the resultant array
 4. if level == result.size, create a new list and add it to the result
 5. Now in that list, insert the elements according to their level
 */

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
        if(root == null) return result;
        
        dfs(root, 0);
        return result;
        
    }
    
    private void dfs(TreeNode root, int level){
        
        //base
        
        if(root == null) return;
        
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        
        result.get(level).add(root.val);
        
        dfs(root.left, level + 1);
        
        dfs(root.right, level + 1);
        
        //logic
    }
}