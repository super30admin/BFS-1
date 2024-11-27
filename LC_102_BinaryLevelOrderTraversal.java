// Time Complexity :O(n)// need to traverse each node once
// Space Complexity :O(n)// Declaring new Array List to store the node values
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No, as already discussed in class


import java.util.*;
import java.io.*;


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val=x;
	}	
}
public class LC_102_BinaryLevelOrderTraversal {
	TreeNode root;
	
	public static void main(String[] args) {
		LC_102_BinaryLevelOrderTraversal tree= new LC_102_BinaryLevelOrderTraversal();
		tree.root= new TreeNode(3);
		tree.root.left= new TreeNode(9);
		tree.root.right= new TreeNode(20);
		tree.root.right.left= new TreeNode(15);
		tree.root.right.right= new TreeNode(7);
		System.out.println("The level order traversal is: ");
		System.out.println(levelOrder(tree.root));
	
	}
	
	 public static List<List<Integer>> levelOrder(TreeNode root) {
	        Queue<TreeNode> queue= new LinkedList<>();
	        List<List<Integer>> result= new ArrayList<>();
	        
	        if (root == null) return result;
	        queue.add(root);
	        while(!queue.isEmpty()){
	            List<Integer> temp = new ArrayList<>();
	            int count = queue.size();
	            
	            for(int i=0; i<count; i++){
	                TreeNode node = queue.poll();
	                temp.add(node.val);
	                if(node.left!=null) queue.add(node.left);
	                if(node.right!=null) queue.add(node.right);
	            }
	            result.add(temp);   
	        }
	        return result;
	        
	    }

}
