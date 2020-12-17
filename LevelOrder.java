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
 * Time Complexity : O(N)
 * Space Complexity : O(H) H is height of tree
   Idea : when level is result.size u r first time visiting that level and when it is not it means it already
   populated. We do dfs by indexing through depth in the result array.
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        helper(root,0);
        return result;
    }
    
    public void helper(TreeNode root,int level){
        if(root == null){
            return;
        }
        if(level == result.size()){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}