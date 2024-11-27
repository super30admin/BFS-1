// Time complexity 0(n)
// space complexity 0(h) [depth of tree]
// Code successfully executed in leetcode.
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
         List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return result;
    
    }
    public void dfs(TreeNode root, int depth){
       // base case
        if (root == null) return;
        
        // logic case
        if(result.size() == depth) result.add(root.val);
        dfs(root.right, depth+1);
        dfs(root.left, depth+1);
    }
}