// Time complexity - O(n)
// Space complexity - O(h)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
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
//Approach 2 using recursion
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        //List<Integer> temp = new ArrayList<>();
        helper(root, 0);
        
        return result;
        
    }
    
    private void helper(TreeNode root, int currentLevel){
        
        if(root == null){
            
            return;
        }
        
        if(result.size() == currentLevel){
            
            result.add(new ArrayList());
           // result.get()
        }
        result.get(currentLevel).add(root.val);
        helper(root.left, currentLevel+1);
        helper(root.right, currentLevel+1);
        
    }
}