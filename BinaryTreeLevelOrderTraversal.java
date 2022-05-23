// Time Complexity : O(N)
// Space Complexity : O(1), ignored the output List
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}

public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return result;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        if(result.size() == level)
            result.add(new ArrayList<>());

        result.get(level).add(root.val);

        if(root.left != null)
            helper(root.left, level+1);
        if(root.right != null)
            helper(root.right, level+1);
    }
}
