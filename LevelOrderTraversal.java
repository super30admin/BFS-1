// Time Complexity :O(n) 
// Space Complexity :O(n/2) or O(2^h) h=height of the tree
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
    List<List<Integer>> output;
    public List<List<Integer>> levelOrder(TreeNode root) {
        output=new ArrayList<>();
        if(root==null)
            return output;
        bfs(root);
        return output;
    }
    private void bfs(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> level=new ArrayList<Integer>();

            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                 level.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            output.add(level);
        }
    }

} 