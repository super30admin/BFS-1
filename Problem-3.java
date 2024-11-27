// Time Complexity :
//      n - number of nodes
//      total time complexity will be O(n)
//
// Space Complexity :
//      n - number of nodes O(n)
//      because we are storing the nodes in each level in queue
//
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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int s = 0;
        if(root == null)
            return al;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            s = q.size();
            for(int i=0;i<s;i++)
            {
                TreeNode temp = q.poll();
                if(i==0)
                {
                    al.add(temp.val);
                }
                if(temp.right!=null)
                {
                    q.offer(temp.right);
                }
                if(temp.left!=null)
                {
                    q.offer(temp.left);
                } 
            }
        }
        return al;
    }
}