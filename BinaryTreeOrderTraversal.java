import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Use a queue to keep track of nodes in the level. 
 * Time Complexity: O(N), where N is the number of nodes
 * Space Complexity: O(N), where N is the number of nodes
 * 
 * Thoughts on where to start before coding: 
 * 1. What does the input look like? [3,9,20,null,null,15,7] recognize there are two    nulls
 * 2. What is the output look like? [
  [3],
  [9,20],
  [15,7]
]
 * 3. The output must return from left to right, level by level. So taking a Breath First Search Approach would be applicable
 * 
 * 4. Does it run on Leetcode? Yes. 
 */
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
        // Output List
        List<List<Integer>> outputList = new ArrayList<>();
        // If root is null return empty list 
        if (root == null) return outputList;
        
        // keep track of the per level nodes
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // add a root to the queue
        queue.add(root);
        // while the queue is not empty
        while (!queue.isEmpty()) {
            // start the current level 
            List<Integer> level = new ArrayList<>();
            
            // number of elements in the current level
            int level_length =  queue.size();
            for (int i = 0; i < level_length; i++) {
                TreeNode node = queue.poll();
                
                // pop out all the elements and add them to the current level
                level.add(node.val);
                
                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // add to outputList
           outputList.add(level);
        }
        return outputList;
    }
}
