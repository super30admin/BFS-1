// Time Complexity : O(n) n is number of nodes
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        if(root==null) return new ArrayList<List<Integer>>(); 
        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int level = 0;
        queue.add(root);
        while(!queue.isEmpty())
        {
            levels.add(new ArrayList<Integer>());
            int level_nodes = queue.size();
            for(int i=0;i<level_nodes;i++)
            {
                TreeNode t = queue.remove();
                levels.get(level).add(t.val);
                if(t.left!=null)queue.add(t.left);
                if(t.right!=null) queue.add(t.right);
            }
            level++;
        }
        return levels;
    }
}