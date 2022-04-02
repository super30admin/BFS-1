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
 time complexity : O(n)
 space complexity : O(log(n))
*/
class Solution {
    List<List<Integer>> output=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
       dfs(root,0);
        return output;
    }
    private void dfs(TreeNode root, int level){
        if(root==null){
            return;
        }
        if(level>=output.size()){
            List<Integer> cache=new ArrayList<>();
            output.add(cache);
        }
        output.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
        
    }
}
