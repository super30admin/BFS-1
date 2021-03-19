// Time Complexity :
O(no.of nodes in the tree)
// Space Complexity :
O(n) as we are using a queue to add all nodes into it and process
// Did this code successfully run on Leetcode :
Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
        
        
        //Define resultant List
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        //Define a Queue to add each node and then process it's children accordingly
        Queue<TreeNode> queue = new LinkedList<>();
        
        //Add the root node to queue
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
           //Define a List to add the nodes at current level
            List<Integer> temp = new ArrayList<>();
           
            for(int i = 0; i < size; i++){
                TreeNode current = queue.remove();
                temp.add(current.val);
                //Add the left and right children of the node removed from the Queue
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);

            }
            result.add(temp);
        }
            
      return result;      
        
        
    }
}
