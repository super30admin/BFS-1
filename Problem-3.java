/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //TC:O(N)
 //SC:O(N)
class Solution {
    public List<Integer> rightSideView(TreeNode root)
    {
      List<Integer> l = new ArrayList<>();
      if(root == null) return l;
      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);
      while(!q.isEmpty())
      {
        int size = q.size();
        for(int i=0;i<size;i++)
        {
            TreeNode m = q.poll();
            if(m.left!=null) q.add(m.left);
            if(m.right!=null) q.add(m.right);
            if(i==(size-1) )
                l.add(m.val);
            
        }
          
      }
       return l; 
    }
}