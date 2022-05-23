// O(n) each node processed once
// O(n) space for recursion

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

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
class Solution {
    List<List<Integer>> levels;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
    
    private void helper(TreeNode node, int level){
        // if output levels array is same as current level, create new list, otherwise on the same list (already been created)
        if (levels.size() == level){
            levels.add(new ArrayList<Integer>());
        }
        
        // add node value to last list in levels
        levels.get(level).add(node.val);
        
        // recursive call for left child node and right child nodes if they are not None
        if (node.left != null){
            helper(node.left, level + 1);
        }
        if (node.right != null){
            helper(node.right, level + 1);
        }
    }
}