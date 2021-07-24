//time n
//space n

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

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root==null) return new ArrayList<>();

        helper(root,0);

        return res;

    }

    private void helper(TreeNode root , int level)
    {
        if(root==null) return;

        if(res.size() == level)
        {
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }

        res.get(level).add(root.val);

        helper(root.left , level+1);
        helper(root.right , level+1);
    }
}
