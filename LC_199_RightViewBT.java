// Time Complexity :O(n)// need to traverse each node once
// Space Complexity :Not sure but definetly less than O(n) as we are storing only one node value from each level
// Did this code successfully run on Leetcode :Yes
//Runtime: 1 ms, faster than 98.73% of Java online submissions for Binary Tree Right Side View.
//Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Binary Tree Right Side View.
// Any problem you faced while coding this :No, as already discussed in class

import java.util.*;
import java.io.*;
//class TreeNode{
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x) {
//		val=x;
//	}	
//}
public class LC_199_RightViewBT {
	TreeNode root;
	 public static List<Integer> rightSideView(TreeNode root) {
	        
	        List<Integer> result= new ArrayList<>();
	        if(root==null) return result;
	        Queue<TreeNode> queue= new LinkedList<>();
	        TreeNode node=root;
	        queue.add(root);
	        while(!queue.isEmpty()){
	            int size= queue.size();
	            for(int i=0;i<size;i++){
	                node= queue.poll();
	                if(node.left!=null) queue.add(node.left);
	                if(node.right!=null) queue.add(node.right);
	            }
	            result.add(node.val);  
	        }
	        return result;
	 }
	 public static void main(String[] args) {
		 LC_199_RightViewBT tree= new LC_199_RightViewBT();
			tree.root= new TreeNode(1);
			tree.root.left= new TreeNode(2);
			tree.root.right= new TreeNode(3);
	
			tree.root.right.right= new TreeNode(5);
			
			tree.root.right.right= new TreeNode(4);
			System.out.println("Right side view of binary tree is: ");
			System.out.println(rightSideView(tree.root));
		
		}
	   
}
