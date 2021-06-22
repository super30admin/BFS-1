// Time Complexity: O(n)
// Space Complexity: O(Edge)

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
        dfs(root,0);
        return result;
    }
    
    private void dfs(TreeNode root, int height){
        if(root == null) return;
        if(result.size() == height){
            result.add(new ArrayList<>());
        }
        result.get(height).add(root.val);
        dfs(root.left, height+1);
        
        dfs(root.right, height+1);
        
        
    }
}