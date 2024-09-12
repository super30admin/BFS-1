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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> output = new ArrayList<>();
        
        if (root == null) return output;
        
        dfs(root,0,output);
        
        return output;
        
    }
    
    private void dfs(TreeNode root, int depth, List<Integer> output){
        if (root == null) return ;
        
        if (depth == output.size()){
            output.add(root.val);
        }
        
        dfs(root.right, depth+1, output);
        dfs(root.left, depth+1, output);
    }
}