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
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> result = new LinkedList<>(); 
        
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int countNodes=q.size();
            
            for(int i=0;i<countNodes;i++)
            {
                TreeNode curNode=q.poll();
                
                if(i == countNodes-1)
                    result.add(curNode.val);
                
                if(curNode.left != null)
                    q.add(curNode.left);
                
                if(curNode.right != null)
                    q.add(curNode.right);
            }
        }
        return result;
        
    }
}