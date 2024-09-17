package Nov11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class BinaryTreeRightSideViewBFS {
    public List<Integer> rightSideView(TreeNode root) {
        
/*
  Time Complexity: O(n) where n is number of nodes in the given tree.
  Because we will be iterating through all nodes of the tree levelwise to reach the rightmost node at every level.
  
  Space Complexity: O(n/2) ~= O(n)
  Because all leaf nodes can be present in the BFS queue at one time, which makes the queue size to n/2.
 
  Did this code successfully run on Leetcode : Yes
 
  Any problem you faced while coding this : No
     
  Approach: 
  BFS approach taken.
            
*/ 
        
        List<Integer> result = new ArrayList<>();
        
         //edge case
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        // iterating through given tree using BFS
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            
            // processing all nodes at a level of the tree and checking if it is the last node of the level,i.e.rightmost node for a level. 
            // If yes, add that node to result list. 
            // If no, add left and right child nodes of the current node to queue to be processed in the next while loop 
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = queue.poll();
                if (i == qSize-1) {
                    result.add(cur.val);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return result;
    }
}
