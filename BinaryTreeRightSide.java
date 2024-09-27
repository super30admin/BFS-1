// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// 	

// Your code here along with comments explaining your approach


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
     List<Integer> out = new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {

            TreeNode node = q.poll();
            if (node == null) return list;
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
            if (q.peek() == null) {
                q.poll();
                q.add(null);
                list.add(node.val);
            }
        }
        return list;
    }
}