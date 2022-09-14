import java.util.ArrayList;
import java.util.List;

// # Problem 1
// Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)


 // Definition for a binary tree node.
 public class Problem1 {
      int val;
      Problem1 left;
      Problem1 right;
     Problem1() {}
      Problem1(int val) { this.val = val; }
      Problem1(int val, Problem1 left, Problem1 right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
 }

// For BFS
// time: O(n)
// Space: O(n)

// For DFS
// time: O(n)
// space: O(h) h = height of tree
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(Problem1 root) {
        result = new ArrayList<>();
        if (root == null) return result;
        dfs(root,0);
        return result;
    }
    
    private void dfs(Problem1 root, int depth) {
        //base
        if (root == null) return;
        
        //logic
        if (depth == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}