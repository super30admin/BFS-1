// Time Complexity : O(N) as we have to visit all the nodes in the linkedList.
// Space Complexity : O(L) where L is the maximum number of nodes at any level in the Tree.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Not really

import java.util.*;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> levelS = new LinkedList<>();
        List<List<Integer>> output = new ArrayList<>();
        
        levelS.add(root);
        
        while(!levelS.isEmpty()) {
            int size = levelS.size();
            List<Integer> curr = new ArrayList<>();
            while(size > 0) {
                TreeNode temp = levelS.poll();
                curr.add(temp.val);

                if(temp.left != null) {
                    levelS.add(temp.left);
                }
                
                if(temp.right != null) {
                    levelS.add(temp.right);
                }
                
                size--;
            }
            output.add(curr);
        }

        return output;
    }

    /* Definition for a binary tree node. */
  public class TreeNode {
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
}