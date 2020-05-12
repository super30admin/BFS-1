/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        result = new ArrayList<>();
        dfs(root,0);
        return result;
        
    }
    
    private void dfs(TreeNode root, int level){
        
        if (root == null)return;
        
        if (level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}