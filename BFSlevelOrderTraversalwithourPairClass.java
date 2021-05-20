// Time complexity - O(n)
// Space complexity - O(n/2) = O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
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
// BFS approach using Queue.
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        
        if(root == null){
            
          return result;
        }
        
        q1.add(root);
       
        
        while(!q1.isEmpty()){
             List<Integer> temp = new ArrayList<>();
            int queueSize = q1.size();
            
            
            for(int i = 0; i < queueSize; i ++){
                
                TreeNode current = q1.poll();
                temp.add(current.val);
                if(current.left != null){
                    
                    q1.add(current.left);
                }
                if(current.right != null){
                    
                    q1.add(current.right);
                }
            }
            
            result.add(new ArrayList(temp));
            
        }
        return result;
    }
}