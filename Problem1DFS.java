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

// what we need in DFS is the level and the node.
// Why the level - because we need to mark that these nodes should go in this list.
// and the way is recursion .
// Time complexity = O(n) // all nodes are iterated over
// Space complexity = O(log(n))// recursive stack.
class Problem1DFS {
    List<List<Integer>>  res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        return res;
    }
    
    private void helper(TreeNode root, int level) {
        if(root==null) {
            return;
        }
        if(level== res.size()) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            res.add(list);
        } else {
            res.get(level).add(root.val);// data structure in a data structure is a reference.
        }
        
        helper(root.left, level+1);
        helper(root.right, level+1);
        
    }
}