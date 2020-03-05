// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

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
        List<List<Integer>> result = new LinkedList<>();
        
        if (root == null)
            return result;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
           int count=q.size();
            List<Integer> curLevel=new LinkedList<>();
            for (int i=0; i<count; i++)
            {
                TreeNode cur=q.poll();
                curLevel.add(cur.val);
                
            if(cur.left != null)
                q.add(cur.left);
                
            if(cur.right != null)
                q.add(cur.right);
            }
            
            result.add(curLevel);
        }
        return result;
    }
}