// Time Complexity : O(n), n=number of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level) {
        //base case
        if(root == null) return;
        
        if(result.size() == level)
            result.add(new ArrayList<>());
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}