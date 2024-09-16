// Time Complexity : O(N) - As we iterate through all the nodes in the tree
// Space Complexity : O(N) - AS We use a  Nested List data structure to store elements
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
    public void helper(TreeNode root,List<List<Integer>> res,int depth){
        if(root == null) return;
        
        if(depth >= res.size()){
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(root.val);
        helper(root.left,res,depth + 1);
        helper(root.right,res,depth + 1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root,res,0);
        return res;
    }
}
// Your code here along with comments explaining your approach