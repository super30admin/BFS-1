//time complexity : O(m*n)
//space complexity : O(m*n)
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
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<List<Integer>>();
       dfs(root,0,result);
       return result;
    }
    private void dfs(TreeNode root, int depth, List<List<Integer>>result){
        if(root==null) return;
        if(result.size()==depth){
            result.add(new ArrayList<Integer>());
        }
        result.get(depth).add(root.val);
        dfs(root.left, depth+1,result);
        dfs(root.right, depth+1,result);
    }
}
