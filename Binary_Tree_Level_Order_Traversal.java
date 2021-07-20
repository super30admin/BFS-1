// 102. Binary Tree Level Order Traversal - https://leetcode.com/problems/binary-tree-level-order-traversal/
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did it run on leetcode? : Yes
// Any problems faced? : No

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
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // base
        if(root == null)
            return result;
        
        // create queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            // calculate size
            int sz = queue.size();
            List<Integer> list = new ArrayList<>();
            // iterate through the level
            for(int i=0; i<sz; i++){
                // poll from queue
                TreeNode curr = queue.poll();
                
                // add to list
                list.add(curr.val);
                
                // left and right children
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            // add to result
            result.add(list);
        }
        return result;
    }
}