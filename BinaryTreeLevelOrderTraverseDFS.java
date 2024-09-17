package Nov11;

import java.util.ArrayList;
import java.util.List;

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
class BinaryTreeLevelOrderTraverseDFS {
    
    /*
  Time Complexity: O(n) where n is no.of nodes.
  Because we are traversing through all nodes of the tree exactly once.
 
  Space Complexity: O(h) where h is height of the tree.
  Because we are traversing towards left child of every node.
 
  Did this code successfully run on Leetcode : Yes
 
  Any problem you faced while coding this : No
     
  Approach: 
  DFS approach taken.
            
*/ 
    
    List<List<Integer>> result = new ArrayList<>();  

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        // edge condition
        if (root == null) {
            return result;
        }
        
        dfs(root, 0);
        return result;
    }
    
    public void dfs(TreeNode root, int level) {
        
        // base condition for recursion
        if (root == null) {
            return;
        }
        
        // logic
        if (result.size() == level) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        
        // recursive call for left and right child of root
        dfs(root.left, level+1);
        dfs(root.right, level+1);
        
    }
    
}