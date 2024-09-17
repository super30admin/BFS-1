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
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
         while(queue.size()!=0)
        {
            int size = queue.size();
             while(size!=0)
             {
                 TreeNode currNode = queue.remove();
                 if(currNode.left!=null) queue.add(currNode.left);
                 if(currNode.right!=null) queue.add(currNode.right);
                 if(size==1) list.add(currNode.val);
                 size--;
             }
        }
        
        return list;
    }
}