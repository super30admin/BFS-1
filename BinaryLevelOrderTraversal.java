/**
 * LeetCode Execution: Smooth
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) to keep the output structure & the Queue
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
  public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      
      Queue<qNode> q = new LinkedList<>();
      
      if (root != null) {
          q.add(new qNode(root, 0));
          
          while (!q.isEmpty()) {
              qNode helper = q.poll();
              
              if(res.size() - 1 < helper.level) 
                  res.add(new ArrayList<Integer>());
              
              res.get(helper.level).add(helper.node.val);
              
              if (helper.node.left != null) {
                  q.add(new qNode(helper.node.left, helper.level + 1));
              }
              if (helper.node.right != null) {
                  q.add(new qNode(helper.node.right, helper.level + 1));
              }    
          }
          
      } 
      
      return res;
      
  }
  
  class qNode {
      public int level;
      public TreeNode node;
      
      public qNode(TreeNode node, int level) {
          this.level = level;
          this.node = node;
      }
  }
}



/**
 * Solution 2: Recursive Solution 
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n): The output storage
 */

 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        int level = 0;
        computeBfs(root, res, level);
        return result;
    }

    public void computeBfs(TreeNode root, List<List<Integer>> result, int level) {
        if (level == result.size())
            result.add(new ArrayList<>());
        
            result.get(level).add(root.val);
            computeBfs(root.left, result, level+1);
            computeBfs(root.right, result, level+1);
    }
 }
