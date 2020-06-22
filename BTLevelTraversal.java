// Time Complexity :O(n). n is the number of nodes
// Space Complexity : O(L). L is the no of leaf nodes
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList();
        
        List<List<Integer>> list = new ArrayList();
        List<Integer>innerList;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        
        while(!queue.isEmpty()){
            int qSize = queue.size();
            innerList = new ArrayList();
            for(int i=0;i<qSize;i++){
                TreeNode top =queue.poll();
                innerList.add(top.val);
                
                if(top.left!=null){
                queue.add(top.left);
                
                }
            if(top.right!=null){
                queue.add(top.right); 
            }
                
            }
            
            list.add(innerList);
        }
        return list;
    }
}
