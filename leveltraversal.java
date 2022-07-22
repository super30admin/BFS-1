// TC:O(n)
// SC:O(h)

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
        if(root == null ) return new ArrayList<>();
        
        result = new ArrayList<>();

        dfs(root,0);
        
        return result;
    }
    
    private void dfs(TreeNode root, int lvl){
        if(root == null) return;
        
        if(lvl == result.size()){
            result .add(new ArrayList<>());
        }
        result.get(lvl).add(root.val);
        dfs(root.left,lvl+1);
        dfs(root.right,lvl+1);
    }
}