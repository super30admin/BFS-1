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

// Time Complexity: Traverse all the node once => O(n)
// Space Complexity: At a single point only that depth of the tree => O(h)
// Did you complete it on leet code: Yes
// Any problems faced: No

// Write your approach here
// Idea here is to use recursive stack to add the elements to the specific level
// if result's size equals to a level, it means that there is no existing list for that level
// in such case we create a new list
// we add the element to specified level and perform the same action on left and right
// nodes of the root.
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root==null) return result;
        preorder(root, 0);
        return result;
    }
    
    public void preorder(TreeNode root, int level) {
        if(root==null) return;
        if(result.size()==level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        preorder(root.left, level+1);
        preorder(root.right, level+1);
    }
}