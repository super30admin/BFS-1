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
// Time Complexity 0(n)
// Space Complexity 0(n)
// BFS Approach
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> level = new ArrayList<>();
        if(root == null)
        {
            return level;
        }
        Queue<TreeNode> q= new LinkedList();
        
        q.add(root);
        while(q.isEmpty() == false)
        {   
         int size = q.size();
            
            List<Integer> l = new ArrayList();
         for(int i=0;i<size;i++)
         { 
            TreeNode curr = q.poll();
            l.add(curr.val);
        if(curr.left != null)
           {
             q.add(curr.left);
           }
        if(curr.right != null)
          {
            q.add(curr.right);
          }
         
        }
          level.add(l);  
        }
      return level;  
    }
}
