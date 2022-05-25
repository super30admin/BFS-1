import java.util.*;

class Solution {
    // DFS Solution
    // Time complexity is O(n)
    // Space complexity is O(h) i.e the height of the tree
    // This solution is submitted on leetcode with zero errors
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        //edge case
        if(root==null) return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        // base case
        if(root == null) return;
        // logic
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}