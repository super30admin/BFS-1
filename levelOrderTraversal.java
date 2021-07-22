// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
        
        //result list
        List<List<Integer>> result = new ArrayList<>();
        
        //edge case
        if(root == null)
            return result;
        
        //create a queue to store the treenode in level order
        Queue<TreeNode> queue = new LinkedList<>();
        
        //add the root to queue initially
        queue.add(root);
        
        while(!queue.isEmpty()){
            //size of the queue == number of nodes in that level
            int size = queue.size();
            
            //create a list for each level
            List<Integer> list = new ArrayList<>();
            
            
            for(int i=0; i<size; i++){
                
                //get the first element in queue
                TreeNode currentNode = queue.remove();
                //add the current node to list
                list.add(currentNode.val);
                //check if left and right child if present for the current node and add it to queue
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                
            }
            
            //add the list to result list
            result.add(list); 
        }
        
        return result;
    }
}