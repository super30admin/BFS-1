package BFS1;

/* Time complexity : o(n) - traversering all n nodes
space complexity: o(n/2) - o(n)- at any point of time n/2 nodes will be there in queue 
Did this code run successfully in leetcode : yes
problems faces : no
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalBFS {

	
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
	 
	class Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	      List<List<Integer>> result = new ArrayList<>();  
	      //base
	      if(root == null)   return result;
	      Queue<TreeNode> q = new LinkedList<>();
	      q.add(root);
	      while(!q.isEmpty()){
	          int size = q.size();
	          List<Integer> l = new ArrayList<>();
	          for(int i=0; i<size; i++){
	              TreeNode curr = q.poll();
	              l.add(curr.val);
	              if(curr.left != null) q.add(curr.left);
	              if(curr.right != null) q.add(curr.right);
	          }
	          result.add(l);
	      }  
	        return result;
	    }
	}

}
