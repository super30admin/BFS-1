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

 //TC :- o(N)
 //Space:o(N): worst case all leaf elements
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
      
        
        List<List<Integer>> result = new ArrayList<>();
          if(root ==  null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> res = new ArrayList<>();
            for(int i = 0;i<size;i++)
            {
                
                TreeNode curr = q.poll();
                res.add(curr.val);
                if(curr.left != null)
                {
                    q.add(curr.left);
                }
                if(curr.right != null)
                {
                    q.add(curr.right);
                }
            }
            result.add(res);
        }
       return result;
        
    }
}