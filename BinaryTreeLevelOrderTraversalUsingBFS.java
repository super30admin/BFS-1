package BFS1;

// Time Complexity : O(n)
// Space Complexity : O(n)   //O(n/2) -> O(n) queue occupies the space for leaf nodes
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class BinaryTreeLevelOrderTraversalUsingBFS {

    List<List<Integer>> result;
    Queue<TreeNode> q;
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) return new ArrayList<>();
        this.result = new ArrayList<>();
        this.q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> r = new ArrayList<>();
            int size = q.size();
            while(size>0)
            {
                TreeNode temp = q.poll();
                r.add(temp.val);
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
                size--;
            }

            result.add(r);
        }
        return result;

    }
}
