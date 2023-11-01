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
        List<Integer>  ans = new ArrayList<>();
        int level =0;
        helper(root,ans,level);
        return ans;
    }

    public void helper(TreeNode node,List<Integer> ans,int level) {
        if(node == null) {
            return;
        }
        if(ans.size() < level+1) {
            ans.add(node.val);
        }
        helper(node.right,ans,level+1);
        helper(node.left,ans,level+1);


    }
}