// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)    return new ArrayList();
        
        List<Integer> result = new ArrayList();
        Deque<TreeNode> queue = new LinkedList();
        queue.offer(root);
        
        int size = 0, value = 0;
        
        while(!queue.isEmpty()){
            
            size = queue.size();
            
            for(int i = 0;i < size; i++){
                TreeNode node = queue.poll();
                value = node.val;
                if(node.left != null)   queue.offer(node.left);
                if(node.right != null)  queue.offer(node.right);
            }
            
            result.add(value);
        }
        return result;
    }
}
