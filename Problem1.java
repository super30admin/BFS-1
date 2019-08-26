// Time Complexity : O(n) - For iterating over all the elements of tree
// Space Complexity : O(n) - using extra space - queue 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I had to search for algorithm
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
        
        List<List<Integer>> result  = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                temp.add(node.val);
            }
            result.add(temp);
        }
        return result;
        
    }
}