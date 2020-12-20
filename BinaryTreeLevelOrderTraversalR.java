/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * LeetCode: Y(https://leetcode.com/problems/binary-tree-level-order-traversal/)
 * Approach: Traverse the tree depth-first way tracking the level during traversal
 * if there is no element at that level in the result arraylist then first allocate new array list for that level at the end
 * append the current node's val to the arraylist of that level
 * explore the left and right child
 */
class Solution {
    List<List<Integer>> levelOrderTraversal;
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrderTraversal = new ArrayList<>();
        // check edge case
        if(root == null) {
            return levelOrderTraversal;
        }
        // start traversing from root i.e. level 0
        dfs(root, 0);
        
        // return calculated levelOrderTraversal
        return levelOrderTraversal;
    }
    private void dfs(TreeNode root, int level) {
        // if root is null then return
        if(root == null) {
            return;
        }
        
        // if level is being explored for the first time then create space for the nodes at that level
        if(level == levelOrderTraversal.size()) {
            levelOrderTraversal.add(new ArrayList<Integer>());
        }
        // append the node's val to its level
        levelOrderTraversal.get(level).add(root.val);
        
        // Explore left child
        dfs(root.left, level + 1);
        
        // Explore right child
        dfs(root.right, level + 1);  
    }
}
