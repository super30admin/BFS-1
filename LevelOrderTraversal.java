/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /**
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 * Accepted on Leetcode: Yes
 
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if(node.left!= null){
                    queue.offer(node.left);
                }
                if(node.right!= null){
                    queue.offer(node.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }
}