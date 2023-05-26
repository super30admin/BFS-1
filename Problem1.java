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
//  Time: O(n) all nodes;
// Space: O(h) height
class Solution { 
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root,0);
        return res;
        
    }

    public void dfs(TreeNode node , int level){
        // base
        if(node == null){
            return;
        }

        // logic
         if(res.size() == level){
             res.add(new ArrayList<Integer>());
         }
         
        List<Integer> list = res.get(level);
        list.add(node.val);
         dfs(node.left,level+1); 
         dfs(node.right,level+1);
    }

}