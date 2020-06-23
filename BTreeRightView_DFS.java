// Time Complexity : O(n) --> where n is number of nodes in the tree  
// Space Complexity : O(h) --> where h is height of the tree
// Did this code successfully run on Leetcode (199): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    // DFS Approach
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level) {
        // base case
        if (root == null) return;
        
        // logic
        if (level == result.size()) {
            result.add(root.val);
        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}