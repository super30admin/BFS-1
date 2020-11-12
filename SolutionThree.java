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
// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : nopes

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
class SolutionThree {
    List<Integer> result=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {

        if(root==null)
            return result;

        dfs(root,0);

        return result;
    }

    public void dfs(TreeNode root,int level)
    {
        if(root==null)
            return;

        if(level==result.size())
            result.add(root.val);
        else
            result.set(level,root.val);

        dfs(root.left,level+1);
        dfs(root.right,level+1);

    }
}