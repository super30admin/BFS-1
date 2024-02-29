//https://leetcode.com/problems/binary-tree-level-order-traversal/
//TC - O(n)
//SC - O(1)
package week5.day1;

import java.util.ArrayList;
import java.util.List;

class Solution_LevelOrderTraversal_DFS {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        //base
        if(root==null)
            return;

        //logic
        if(level==result.size()){
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }
        result.get(level).add(root.val);

        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}
public class LevelOrderTraversal_DFS {

}
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