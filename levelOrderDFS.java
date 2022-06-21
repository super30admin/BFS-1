// https://leetcode.com/problems/binary-tree-level-order-traversal/
// Level Order problem solving using DFS

// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;   
    }
    
    private void dfs(TreeNode root, int level) {
        // base 
         if(root == null) return;
        
        // logic
        if(result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}