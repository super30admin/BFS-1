// Time Complexity : O(n) - For iterating over all the elements of tree
// Space Complexity : O(n) - using extra space - queue 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
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
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return result;
        }
        
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
           
            for(int i = 1; i<=n; i++){
                TreeNode node = q.poll();
                if(i == n){
                    result.add(node.val);
                }
                if (node.left != null){
                    q.add(node.left); 
                }     
                if (node.right != null){
                    q.add(node.right);
                }
            }
        }
        return result;
    }
    
}