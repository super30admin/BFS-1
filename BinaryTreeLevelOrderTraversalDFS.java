// Time Complexity : O(N)
// Space Complexity : O(H), for DFS, stack will be height of tree in worst case
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

public class BinaryTreeLevelOrderTraversalDFS {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        if(result.size() == level)
            result.add(new ArrayList<>());

        result.get(level).add(root.val);

        if(root.left != null)
            dfs(root.left, level+1);
        if(root.right != null)
            dfs(root.right, level+1);
    }
}

// Time Complexity : O(N)
// Space Complexity : O(N/2) = O(2^h) = O(N) , N=#nodes h=height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class BinaryTreeLevelOrderTraversalBFS {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode  curr = q.poll();
                level.add(curr.val);
                if(curr.left !=null) q.add(curr.left);
                if(curr.right !=null) q.add(curr.right);
            }
            result.add(level);

        }
        return result;
    }
}
