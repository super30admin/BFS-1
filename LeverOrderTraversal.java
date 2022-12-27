
// Time Complexity : O(n)
 // Space Complexity : O(n)
 // Did this code successfully run on Leetcode : Yes 
 // Any problem you faced while coding this : No


 // Your code here along with comments explaining your approach

import java.util.*;

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
 
class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ll = new ArrayList<>();
        if (root == null) return ll;
        Queue<TreeNode> qq= new LinkedList<>();
        qq.offer(root);
        while (!qq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = qq.size();
            for (int i =0;i<size;i++){
                TreeNode node = qq.poll();
                temp.add(node.val);
                if (node.left != null){
                    qq.offer(node.left);
                }
                if (node.right != null){
                    qq.offer(node.right);
                }
            }
            ll.add(temp);
        }
        return ll;
    }
}