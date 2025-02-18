// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach:
 * This problem is about performing a level-order traversal of a binary tree using DFS. 
 * I used a helper function `dfs` that takes a node, its level, and the result list, adding nodes' values to corresponding levels. 
 * The base case checks for null nodes, and if the level is not yet present in the result, a new list 
 * is created to store the node values at that level. 

 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        // This list will hold the final result of the level-order traversal
        List<List<Integer>> result = new ArrayList<>();
        
        // Start the DFS traversal from the root at level 0
        dfs(root,0, result);
        
        // Return the final result with all the node values grouped by levels
        return result;
    }

    // Helper DFS function to traverse the tree
    private void dfs(TreeNode node, int level, List<List<Integer>> result) {
        // Base case: If the node is null, just return as there is nothing to process
        if(node == null) {
            return;
        }
        
        // Logic: If the result list does not yet have a list for the current level, create one
        if(result.size() == level) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }
        
        // Add the current node's value to the corresponding level's list in the result
        result.get(level).add(node.val);

        // Recursively call DFS for the left and right children, increasing the level by 1
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }
}
