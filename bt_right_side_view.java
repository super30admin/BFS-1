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
 
 BFS Solution: 
 
 Time Complexity: O(N)
 Space Complexity: O(N/2) as the last level will have n/2 nodes;
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            int last = -1;
            for(int i=0; i<size; i++)
            {
                TreeNode curr = q.poll();
                last = curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            
            result.add(last);
        }
        return result;
    }
}