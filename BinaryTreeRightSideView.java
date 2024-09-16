/**
 * LeetCode Execution: Ran with no problems but Slow Runtime: 12.98%, Me not Happy :-(
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public List<Integer> rightSideView(TreeNode root) {
      
      List<List<Integer>> allNodes = new ArrayList<>();
      List<Integer> res = new ArrayList<>();
      Queue<Node> q = new LinkedList<>();
      
      if (root != null) {
          q.add(new Node(root, 0));
          
          while(!q.isEmpty()) {
              Node tmp = q.poll();
              if(allNodes.size() - 1 < tmp.level )
                  allNodes.add(new ArrayList<Integer>());
              allNodes.get(tmp.level).add(tmp.node.val);
              
              if(tmp.node.left != null)
                  q.add(new Node(tmp.node.left, tmp.level + 1));
              if(tmp.node.right != null)
                  q.add(new Node(tmp.node.right, tmp.level + 1));
          }
          
          for (int i = 0; i <allNodes.size(); i++) {
              int lastElm = allNodes.get(i).size() - 1;
              res.add(allNodes.get(i).get(lastElm));
          }
      } 
      
      return res;
      
  }
  
  public class Node {
      int level;
      TreeNode node;
      
      Node(TreeNode node, int level) {
          this.node = node;
          this.level = level;
      }
  }
}