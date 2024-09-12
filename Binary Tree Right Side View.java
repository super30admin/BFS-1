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

//Time complexity= O(n) 
//Space Complexity = O(h), h=height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//Create a helper function which has parameters TreeNode and a integer variable to keep track of level. We are checking that whether the size of the result List that we have created globally is equal to the level we are at, and if it is then we are adding the value of current node to that list. As we have to find right side view of tree we are going to right first and then going to left.

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode currNode,int level)
    {
        //base case
        if(currNode==null) return;
        
        
        //Logic
        if(level == result.size()) 
            result.add(currNode.val);
        
        helper(currNode.right,level+1);
        helper(currNode.left,level+1);
        
    }
}