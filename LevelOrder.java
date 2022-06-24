// Time Complexity : O(n) where n is total no of nodes
// Space Complexity : O(n) because in the worst case half of the nodes(all leaves) will be inside the queue.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.

import java.util.*;

class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                li.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(li);
        }

        return result;
    }
}

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