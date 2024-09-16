// Time Complexity : O(N) - As we iterate through all the nodes in the tree
// Space Complexity : O(N) - AS We use a List data structure to store elements
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
    
    public void helper(TreeNode root,List<Integer> arr1,int currdepth){
        if(root == null) return;
        
        if(currdepth == arr1.size()) arr1.add(root.val);
        
        helper(root.right,arr1,currdepth + 1);
        helper(root.left,arr1,currdepth + 1);
        
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arr1 = new ArrayList<>();
        helper(root,arr1,0);
        return arr1;
    }
}
// Your code here along with comments explaining your approach