package Nov11;

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
class BinaryTreeRightSideViewDFS {
    
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        
/*
  Time Complexity: O(n) where n is number of nodes in the given tree.
  Because we will be iterating through all nodes of the tree levelwise to reach the rightmost node at every level.
  
  Space Complexity: O(h) where he is height of the tree.
  Because recursive stack can hold h elements at the same time.
 
  Did this code successfully run on Leetcode : Yes
 
  Any problem you faced while coding this : No
     
  Approach: 
  DFS approach taken and we go towards right.
            
*/   
        //edge case
        if (root == null) {
            return result;
        }
        
        dfs(root, 0);
        return result;
    }
    
    // recursive helper function for DFS
    public void dfs(TreeNode root, int level) {
        
        // base condition for recursion
        if (root == null) {
            return;
        }
        
        // logic
        // moving towards right, hence we can keep replacing the value in the result list for a level as we move towards the right
        if (result.size() == level) {
            result.add(root.val);
        }
        
        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}
