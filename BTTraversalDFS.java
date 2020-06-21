// Time Complexity :O(n). n is the number of nodes
// Space Complexity : O(H). H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

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
    List<List<Integer>> list;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList();
        
        list = new ArrayList();
        
         dfsLevelTraversal(root,0);
        return list;
    }
    
    private void dfsLevelTraversal(TreeNode root,int level){
        
        if(root==null) return;
        
        if(list.size()==level)
            list.add(new ArrayList());
        
        list.get(level).add(root.val);
        dfsLevelTraversal(root.left,level+1);
        dfsLevelTraversal(root.right,level+1);
        
        
        
        
    }
}
