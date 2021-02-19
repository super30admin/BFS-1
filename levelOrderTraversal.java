// Time Complexity : O(n) - n is the number of nodes
// Space Complexity : O(max. breadth) or diameter
// Works on leetcode

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
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level_output = new ArrayList<>();
            // Empty the queue
            for(int i = 0;i<size;i++){
                TreeNode front = queue.poll();
                level_output.add(front.val);
                // Add children of the current level
                if(front.left!=null){
                    queue.add(front.left);
                }
                if(front.right!=null){
                    queue.add(front.right);
                }
            }
            // Append the level to the result
            result.add(level_output);
        }
        return result;
    }
}
