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
        
        List<List<Integer>> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> bfs_queue = new LinkedList<>();
        
        bfs_queue.offer(root);
        
        
        
        
        while(!bfs_queue.isEmpty()){
            
            int size = bfs_queue.size();
            List<Integer> level = new LinkedList<>();
            
            while(size > 0){
                
                TreeNode curr = bfs_queue.poll();
                level.add(curr.val);
                
                //explore all the neighbors.
                
                //meaning right and left children.
                
                if(curr.left != null){
                    bfs_queue.offer(curr.left);
                }
                
                if(curr.right != null){
                    bfs_queue.offer(curr.right);
                }
                
                size --;
                
            }
            
            result.add(level);
        }
        
        return result;
    }
}