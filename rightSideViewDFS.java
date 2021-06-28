package BFS1;

/* Time complexity : o(n) 
space complexity: o(n) 
Did this code run successfully in leetcode : yes
problems faces : no
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightSideViewDFS {
	
	 //Definition for a binary tree node.
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
	
	  List<Integer> result;
	    public List<Integer> rightSideView(TreeNode root) {
	        result = new ArrayList<>();
	        if(root == null) return result;
	        dfs(root,0);
	        return result;
	    }
	    
	    private void dfs(TreeNode root, int level){
	        //base
	        if(root == null) return;
	        //logic
	        if(result.size() == level){
	            result.add(root.val);
	        }
	        
	        dfs(root.right, level+1);
	        dfs(root.left, level+1);
	    }
	 }

