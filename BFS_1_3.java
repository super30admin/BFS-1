//TimeComplexity: O(n)
//SpaceComplexity: O(n)
//Leetcode: Yes

//Right Side View

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
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return list;
        helper(root,0);
        return list;
    }
    private void helper(TreeNode node, int level){
        if(node != null)
        list.add(node.val);
        if(node.right != null)helper(node.right, level+1);
        if(node.left!= null && node.right == null)helper(node.left, level+1);
    }
}