// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.res = new ArrayList<>();
        helper(root,0);
        return res;
    }

    private void helper(TreeNode root, int level) {
        // base case
        if(root == null) return;
        // logic
        if(res.size() < level+1) {
            List<Integer> resLevel = new ArrayList<>();
            resLevel.add(root.val);
            res.add(resLevel);
        }else {
            res.get(level).add(root.val);
        }

        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}