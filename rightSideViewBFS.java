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

public class rightSideViewBFS {
	
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
	
	    public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> result = new ArrayList<>();
	        if(root == null) return result;
	        
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        
	        while(!q.isEmpty()){
	            int size = q.size();
	            for(int i=0; i<size; i++)
	            {
	               TreeNode curr = q.poll();
	               if(i == size-1){
	                result.add(curr.val);
	                }
	                if(curr.left!= null) q.add(curr.left);
	                if(curr.right!=null) q.add(curr.right);
	            }
	        }
	        return result;
	     }
	 }

