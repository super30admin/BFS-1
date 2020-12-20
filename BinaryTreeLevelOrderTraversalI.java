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
/**
 * Time Complexity: O(N) where N is the number of nodes in the binary tree
 * Space Complexity: O(N) where N is the number of nodes in the binary tree
 * LeetCode: Y(https://leetcode.com/problems/binary-tree-level-order-traversal/)
 * Approach: 
    Maintain a queue to process the nodes of the tree level-wise
    Maintain a arraylist to save the nodes at each level
    Enqueue the left and right child if valid
    At the beginning of each pass, only the nodes at next level will be in the queue
    In each pass, only process the nodes at that level using queue size i.e.
        add each node's val to the arraylist of current level
        if there is a left or child then enqueue each of them
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<List<Integer>>();
        // Check for edge case i.e. empty tree
        if(root == null) {
            return levelOrderTraversal;
        }
        // Initialize a queue to store the nodes level-wise
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        // Enqueue the root initially
        q.add(root);
        
        // Loop until the queue is empty i.e. loop until entire tree is traversed
        while(!q.isEmpty()) {
            // get current queue size
            int queueCurrentSize = q.size();
            
            // initialze an Arraylist to store the nodes at current level
            List<Integer> currentLevelNodes = new ArrayList<Integer>();
            
            // To process all the nodes at current level
            for(int i = 0 ; i < queueCurrentSize ; i++) {
                // get the node at the front of the queue to process
                TreeNode currentNode = q.poll();
                
                // add the current node's val to the list of currentLevelNodes
                currentLevelNodes.add(currentNode.val);
                
                // check if the processed node has a left child, if yes then enqueue the left child
                if(currentNode.left != null) {
                    q.add(currentNode.left);
                }
                
                // check if the processed node has a right child, if yes then enqueue the right child
                if(currentNode.right != null) {
                    q.add(currentNode.right);
                } 
            }
            
            // add the list of the nodes at current level to the main arraylist before processing the next level
            levelOrderTraversal.add(currentLevelNodes);
        }
        
        return levelOrderTraversal;
    }
}
