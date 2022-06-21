//Time O(n) where n is the number of nodes in the tree
//Space O(n) since we have a queue that can hold n elements

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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res= new ArrayList<>();
        if(root==null)
            return res;
        
        Queue<TreeNode> q= new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty())
        { int count = q.size();
          List<Integer> temp  = new ArrayList<>();
          for(int i =0;i<count;i++)
          {
              TreeNode curr= q.poll();
              temp.add(curr.val);
              if(curr.left!=null)
                  q.add(curr.left);
              if(curr.right!=null)
                  q.add(curr.right);
              
          }
         res.add(temp);
            
        }
        return res;
    }
}