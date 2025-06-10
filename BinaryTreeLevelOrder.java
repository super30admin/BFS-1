// Time Complexity : O(n)
// Space Complexity : O(1_
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : none
// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int level){
        if(root == null) return;
        if(result.size() == level) result.add(new ArrayList<>());
        result.get(level).add(root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
