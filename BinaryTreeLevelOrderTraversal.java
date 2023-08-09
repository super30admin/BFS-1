// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.*;


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // Create a list to store the level order traversal

        if (root == null) {
            return result; // If the tree is empty, return the empty list
        }

        Queue<TreeNode> queue = new LinkedList<>(); // Create a queue for level order traversal
        queue.offer(root); // Add the root node to the queue

        while (!queue.isEmpty()) { // Loop until the queue is empty (all levels are processed)
            int levelSize = queue.size(); // Get the number of nodes at the current level
            List<Integer> levelNodes = new ArrayList<>(); // Create a list to store nodes' values at the current level

            for (int i = 0; i < levelSize; i++) { // Process nodes at the current level
                TreeNode node = queue.poll(); // Dequeue a node from the queue
                levelNodes.add(node.val); // Add the node's value to the list

                if (node.left != null) { // If the node has a left child, enqueue it
                    queue.offer(node.left);
                }
                if (node.right != null) { // If the node has a right child, enqueue it
                    queue.offer(node.right);
                }
            }

            result.add(levelNodes); // Add the list of nodes' values at the current level to the result
        }

        return result; // Return the level order traversal result
    }
}