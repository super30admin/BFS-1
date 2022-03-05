// Time Complexity : O(n)
// Space Complexity : O(n)

// Approach: create 2 queues, one for a level and the other for main result.

// LC- 102. Binary Tree Level Order Traversal

import java.util.*;

public class BTLevelOrderTraversal {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Queue<TreeNode> curr = new LinkedList<>();
    curr.add(root);

    Queue<TreeNode> next = new LinkedList<>();
    List<Integer> currLevel = new ArrayList<>();

    while (!curr.isEmpty()) {
      TreeNode node = curr.remove();
      currLevel.add(node.val);

      if (node.left != null) {
        next.add(node.left);
      }

      if (node.right != null) {
        next.add(node.right);
      }

      if (curr.isEmpty()) {
        result.add(currLevel);
        currLevel = new ArrayList<>();

        curr = next;
        next = new LinkedList<>();
      }
    }

    return result;
    // }
  }
}
