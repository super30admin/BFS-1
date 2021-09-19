// Time Complexity : O(n), We traverse once through all the nodes.
// Space Complexity : O(n/2)=O(n), A queue is created which has a maximum of n/2 elements at once in the last level
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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

//This is a iterative solution using BFS algorithm. Each level is traversed entirely and only then we proceed to the next level
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int length = q.size();
            for(int i=0;i<length;i++){
                TreeNode curr  = q.poll();
                temp.add(curr.val);
                if(curr.left!= null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
            }
            ans.add(temp);
        }return ans;
    }
}