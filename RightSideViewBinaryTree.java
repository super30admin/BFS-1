package demo;

import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(n)
//Space Complexity : O(1)( ignoring the recursive stack)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : Found this DFS method easier than BFS


public class RightSideViewBinaryTree {

	
//	÷ * Definition for a binary tree node.
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	class Solution {
	    public List<Integer> rightSideView(TreeNode root) {
	        
	        List<Integer> result = new ArrayList<>();
	        //calling helper with base case
	        rightSideHelper(root, result, 0);
	        leftSideHelper(root, result, 0);
	        
	        return result;
	    }
	    
	    private void rightSideHelper(TreeNode root, List<Integer> result, int depth){    
	        //edge case
	        if(root == null) return;
	        // base case
	        if(depth == result.size()){
	            result.add(root.val);
	        }
	        //for right side view we recursively call root.right first, then root.left
	         rightSideHelper(root.right, result,depth +1);
	        rightSideHelper(root.left, result,depth +1);
	        
	    }
	    
	    
	    private void leftSideHelper(TreeNode root, List<Integer> result, int depth){    
	        //edge case
	        if(root == null) return;
	        // base case
	        if(depth == result.size()){
	            result.add(root.val);
	        }
	        //for left side view we recursively call root.left first, then root.right
	        rightSideHelper(root.left, result,depth +1);
	         rightSideHelper(root.right, result,depth +1);
	       
	        
	    }
	}
}
