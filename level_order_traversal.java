// Time Complexity : O(n)
// Space complexity : O(n)

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
       
        // Result
        List<List<Integer>> result =  new ArrayList<>();
        
        if (root == null){
            return result;
        }
        
        // Queue to store the elements
        Queue<TreeNode> q = new LinkedList<>();
        
        // push the root into the queue
        q.add(root);

     
        while (! q.isEmpty() ) {
        
            
            // describes the number of element to be pushed at the current level
            int size = q.size();
                                
            // Current list at the level
            List currlevel = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {

                 // Current element
                TreeNode out = q.poll();
                
                 // Add to the list
                currlevel.add(out.val);
                
                if (out.left != null){
                    q.add(out.left);
                }

                
                if (out.right != null){
                     q.add(out.right);
                }
               
            }
            
            result.add(currlevel);
            
            
        }
        
        
        
        return result;
    }
    
}