// Time Complexity : O(n) => As we iterate over the n nodes
// Space Complexity : O(h) where h is the height of the tree (Recursive stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach 2: Using recursive DFS. Take level variable to keep the track the of
 * the levels. Then compare if level == size of the resulatnt list, initialize
 * the new list and the node. If not then simply fetch the level and add the new
 * node.
 */
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        dfs(root, 0);

        return result;
    }

    private void dfs(TreeNode root, int level) {

        if (root == null) {
            return;
        }

        int size = result.size();

        if (size == level) {
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
        }

        //If list is already initialized for that level, append the new element
        result.get(level).add(root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}