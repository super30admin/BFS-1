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
 
 TC - O(N) where N is the number of nodes in tree.
 SC - O(N)
 
 
 */

// 15,7


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if (root == null)
        {
            return new ArrayList<>();
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        List<List<Integer>> result = new ArrayList<>();
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            List<Integer> levelResult = new ArrayList<>();
            
            for (int i=0; i<size; i++)
            {
                TreeNode remove = queue.remove();
                levelResult.add(remove.val);

                if (remove.left != null)
                {
                    queue.add(remove.left);
                }

                if (remove.right != null)
                {
                    queue.add(remove.right);
                }   
            }
            
            result.add(levelResult);
        }
        
        return result;
    }
}
