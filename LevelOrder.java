//time complexity: O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
       
         List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        //maintaining queue for processing nodes
        //current queue
        Queue<TreeNode> qCurr = new LinkedList<>();
        //maintaining curr level in another queue
        List<Integer> currLevel = new ArrayList<>();
        
        int size = 1;
        
        //add root to queue
        qCurr.add(root);

        //iterate until queue is empty
        while(!qCurr.isEmpty()) {

            //while current queu is not empty
            //add nodes to current level
            while(size > 0) {
                TreeNode node = qCurr.remove();

                currLevel.add(node.val);
                size--;

                //add the left and right nodes to current queue
                if(node.left != null) qCurr.add(node.left);
                if(node.right != null) qCurr.add(node.right);
            }
            
            //add items from current level to result
            result.add(currLevel);

            //re initialize current level
            currLevel = new ArrayList<>();

            size = qCurr.size();

        }
        return result;
    }
}