/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// TC: O(N) .> No. of nodes in the tree
// SC: O(K) -> K nodes in the queue at a given time
// Did it run successfully on Leetcode? : Yes
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList();
        if (root == null)
           return levels;
       
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            levels.add(new ArrayList());
            TreeNode node;
            for ( int i = 0; i < size; i++)
            {
               node = queue.poll();
               levels.get(level).add(node.val);
              if (node.left != null)
                queue.add(node.left);
              if (node.right != null)
                queue.add(node.right);
            }
           
           level++; 
        }
        return levels;
    }
}
