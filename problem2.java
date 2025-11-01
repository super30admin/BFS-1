// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

/*
 * Approach
 * In this code we are using the DFS solution, 
 * we are x_depth and y_depth as global var to keep track of the depth where the ele was found and in the end we will compare
 * them to check if them are equal or not
 * 
 * for dfs we will use a recurcive funtion which will have root, x, y, and depth as the parameter of recursion
 * in the funciton logic we will check if the value of the cur node is equal to x or y
 * then
 * before going to the next recursive call if the next nodes are nulls or not
 * if not then we check if x and y are the childrens or not if yes we will return
 * 
 */

class Solution {
    int x_depth;
    int y_depth;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0);
        if (y_depth == 0 && x_depth == 0)
            return false;
        return x_depth == y_depth;
    }

    private void dfs(TreeNode root, int x, int y, int depth) {
        // base
        if (root == null)
            return;

        // logic

        if (root.val == x) {
            x_depth = depth;
        }
        if (root.val == y) {
            y_depth = depth;
        }
        if (root.left != null && root.right != null) {
            if (root.left.val == x && root.right.val == y) {
                return;
            }
            if (root.left.val == y && root.right.val == x) {
                return;
            }
        }
        // recursion
        dfs(root.left, x, y, depth + 1);
        dfs(root.right, x, y, depth + 1);

    }
}