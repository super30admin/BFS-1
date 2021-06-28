package BFS1;

/* Time complexity : o(n) - traversering all n nodes
space complexity: o(h) - o(n)- at any point of time h, height of the tree nodes will be there in queue 
Did this code run successfully in leetcode : yes
problems faces : no
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalDFS {

	
	 // Definition for a binary tree node.
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
	      if(root == null)   return result;
	      dfs(root, 0);
	        return result;
	    }
	    
	    private void dfs(TreeNode root, int level){
	        //base
	        if(root == null) return;
	        //logic
	        if(result.size() == level) {
	            result.add(new ArrayList<>());
	        }
	        dfs(root.left, level+1);
	        //stack.pop()
	        result.get(level).add(root.val);
	        dfs(root.right, level+1);
	        

	    }

}
