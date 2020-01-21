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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> finalList = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        int s = 0;
        if(root==null)
            return finalList;
        q.offer(root);
        while(!q.isEmpty())
        {
            ArrayList<Integer> subList = new ArrayList<>();
            s = q.size();
            for(int i=0;i<s;i++)
            {
                if(q.peek().left!=null)
                {
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null)
                {
                    q.offer(q.peek().right);
                }
                subList.add(q.poll().val);
            }
            finalList.add(subList);
        }
        return finalList;
    }
}