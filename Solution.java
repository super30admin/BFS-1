//binary-tree-level-order-traversal using DFS
//TC:O(n)..traverse through all the nodes
//SC:O(n)..size of recursion stack

import java.util.ArrayList;
import java.util.List;


 // Definition for a binary tree node.
  class TreeNode {
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

class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {

        dfs(root,0);
        return result;
    }
    public void dfs(TreeNode root,int level)
    {
        //base case
        if(root==null)
        {
            return;
        }

        //for every first node of new level , initialize new arraylist
        if(result.size()==level)
        {
            result.add(new ArrayList<Integer>());
        }
        //add nodes to the level
        result.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);

    }
}