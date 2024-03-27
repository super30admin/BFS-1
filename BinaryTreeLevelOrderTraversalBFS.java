Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
// Time Complexity : O(n) where 'n' is the number of nodes in the tree.
// Space Complexity : O(n/2) i.e. O(n).
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/binary-tree-level-order-traversal/
// Any problem you faced while coding this : No
                                   
                                   
                                   
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> li = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode current = queue.poll();
                li.add(current.val);
               if(current.left!=null) queue.add(current.left);
                 if(current.right!=null) queue.add(current.right);
            }
            result.add(li);
        }
        return result;
    }
}
