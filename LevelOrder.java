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
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        result = new ArrayList<>();
        helper(root,0);
        return result;
        
      }
    
    public void helper ( TreeNode root, int lvl)
    {
        if(root==null)
        {
            return;
        }
        
        if(result.size()==lvl)
        {
            result.add(new ArrayList<>());
            
        }
        
        result.get(lvl).add(root.val);
        
        
        helper(root.left,lvl+1);
        helper(root.right,lvl+1);
        
    }
}
        
        // if(root==null)
        // {
        //     return new ArrayList<>();
//         }
        
//         List<List<Integer>> res = new ArrayList<>();
        
//         Queue<TreeNode> q = new LinkedList<>();
        
//         q.add(root);
//         while(!q.isEmpty())
//         {
//             int size = q.size();
//             List<Integer> ans = new ArrayList<>();
         
//             while(size > 0)
//             {
//                 TreeNode curr = q.poll();
//                 ans.add(curr.val);
//                 if(curr.left!=null)
//                 {
//                     q.add(curr.left);
                    
//                 }
//                 if(curr.right!=null)
//                 {
//                     q.add(curr.right);
//                 }
//                 size--;
//             }
//             res.add(ans);
//         }
        
//         return res;
        
  