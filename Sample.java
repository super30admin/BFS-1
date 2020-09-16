// Problem 1 - Binary Tree Level Order Traversal
// Time Complexity: O(n) where n = number of nodes
// Space Complexity: O(n)

// Algorithm
// 1 - initiliaze a queue
// 2 - while condition
// 3 - loop over the size of queue
// 4 - poll from Queue
// 5 - check if node.left not null, add to queue
// 6 - check if node.right not null, add to queue
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
    if (root == null) {
      return new ArrayList<>();
    }
    // 1
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    queue.add(root);
    // 2
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> temp = new ArrayList<>();
      
      // 3
      for (int i=0; i<size; i++) {
        // 4
        TreeNode node = queue.poll();
        temp.add(node.val);
        
        // 5
        if (node.left != null) {
          queue.add(node.left);
        }
        // 6
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      result.add(temp);
    }

    return result;
  }
}

// Problem 2 - Course Schedule
