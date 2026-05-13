// https://leetcode.com/problems/binary-tree-level-order-traversal/
// Time Complexity : O(n) where n is the number of nodes in the tree.
// Space Complexity : O(h) where h is the height of the tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level){
        if(root == null) return;
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        dfs(root.left, level +1);
        result.get(level).add(root.val);
        dfs(root.right, level +1);
    }
}