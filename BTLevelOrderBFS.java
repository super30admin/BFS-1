//Time Complexity - O(n) - bacuase we process all the nodes
//Space Complexity - O(n/2) - width of leaf nodes 


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
//BFS solution
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);
      //null case
      if(root == null){
        return result;
      }
      
      //put the parent and children in queue
      while(!q.isEmpty()) {
        int size = q.size();
        List<Integer> li = new ArrayList<>();
      
        //check the queue size and add the nodes in queue and listy
        for(int i= 0; i< size;i++) {
          TreeNode curr = q.poll();
          System.out.println(curr.val);
          li.add(curr.val);
          if(curr.left != null) q.add(curr.left);
          if(curr.right != null) q.add(curr.right);
        }
        //once the level completed add the list in resultant list
        result.add(li);
      }
      //System.out.println(li);
      return result;
    }
}