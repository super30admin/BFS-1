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
//tc - o(n)
//sc-o(h)
class Solution {
    List<List<Integer>> result ;
    public List<List<Integer>> levelOrder(TreeNode root) {
       result = new ArrayList<>();
       dfs(root,0);
        return result;
  
    }
     private void dfs(TreeNode root, int depth)
     {
         //base case
         if(root == null) return;
         //logic
         if(result.size() == depth)
         {
            result.add(new ArrayList<>());
         }
         
             result.get(depth).add(root.val);
         
         
         dfs(root.left,depth+1);
         dfs(root.right,depth+1);
     }
}