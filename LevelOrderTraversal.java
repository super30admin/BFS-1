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
        
        
        // Time compelexity O(total.no.of elements in the tree) : O(n)
            //Because we are visiting each and every node once during the program.
        
        // Space complexity O(max no.of elements at any level) : O(breadth of the tree)
            // n/2 is the max no of elements which will be found in leaf. O(n/2) ~ O(n)
        
    
        // Result array
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        // Queue to store the elements at each level
        Queue<TreeNode> q = new LinkedList<>();
        
        // Starting process by adding root to the queue initially
        q.add(root);
        
        // We should continue till all the elements in queue are taken out
        while(!q.isEmpty()) {
            
            // We have that many elements in the given level.
            // We've to now iterate over that many elements and add them to the result array
            int size = q.size();
            
            List<Integer> level = new ArrayList<>();    
            
            //Processing each element in the queue
            for(int i= 0; i < size; i++) {
                TreeNode curr = q.poll();
                
                // Adding element to the level
                level.add(curr.val);
                
                // Adding left child of the current element to the Queue
                if(curr.left != null) q.add(curr.left);
                
                // Adding right child of the current element to the Queue
                if(curr.right != null) q.add(curr.right);
            }
            
            // After processing all the elements in the queue in to a level arraylist add that list to result
            result.add(level);
            
        }
        
        return result;
        
    }
}
