/**LC-199
 * 
 * Time Complexity : O(N) 
 * Space Complexity : O(H)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm: I will doing recursion by going on the right of the tree (SAME as DFS left recursion with slight modification in 5th step)
 1. If root == null return result
 2. Created a recursive function dfs which will go till any of the node located at the most depth
 3. At any given node, check the level and the resultant array
 4. if level == result.size, add the element in the result array. (Size of result array = height of tree)
 5. Else do nothing. (Only this modification)
  6. Call dfs(root.right, level+1)
 7. Call dfs(root.left, level+1)
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
    
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        
         result = new ArrayList<>();
        
        //edge
        if(root == null) return result;
        
        dfs(root, 0);
        
        return result;
    }
    
    public void dfs(TreeNode root, int level){
        
        //base
        if(root == null) return;
        
        if(result.size() == level){
            result.add(root.val);
        }
       
        dfs(root.right, level + 1);
        
        dfs(root.left, level + 1);
        
    }
}