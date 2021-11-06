// 102 Binary Tree Level order traversal 
// solved on leetcode
// Time Complexity -- O(n)
// Space complexity -- O(n)
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
        result = new ArrayList();
        
        helper(root,1);
        return result;
    }
    
    private void helper(TreeNode root, int level){
        if(root==null){
            return ;
        }
        if(level>result.size()){
            result.add(new ArrayList());
        }
        result.get(level-1).add(root.val);
        
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}