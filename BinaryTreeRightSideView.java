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
 // Time Complexity : O(n) n:we are visiting all nodes once
 // Space Complexity : O(n) inserting all nodes in queue
 // Did this code successfully run on Leetcode : Yes
 // Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Use bfs method through queue and traverse till the leaf nodes.
 2. Maintain size of queue to track the level.
 */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if(root == null) return l;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                TreeNode nn = q.poll();
                if(i==(size-1)){
                    l.add(nn.val);
                }
                if(nn.left!=null){
                    q.add(nn.left);
                }
                if(nn.right!=null){
                    q.add(nn.right);
                }
            }  
        }
        return l;
    }
}