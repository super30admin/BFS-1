// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) where n is the number of nodes in the tree STACK space is O(h) where h is the height of the tree 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will be using a helper function to perform a depth first traversal of the tree.
// We will keep track of the level of the tree we are currently on and add the values of the nodes at that level to a list.
// We will add that list to the result list at the end of the traversal.
//  We will continue this process until we have traversed all the levels of the tree.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     
 *     TreeNode() {}
 *     
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *     
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {

        result = new ArrayList<>();

        helper(root, 0);

        return result;
    }

    public void helper(TreeNode root, int level) {

        if (root == null) {
            return;
        }

        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}