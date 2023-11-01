package Q_102_Binary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its level order traversal as:
//[
//  [3],
//  [9,20],
//  [15,7]
//]

//Time Complexity  : O(n)
//Space Complexity : O(n)
class Solution {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t = new TreeNode(3);
		t.left = new TreeNode(9);
		t.right = new TreeNode(20);
		t.left.left =  null;
		t.left.right = null;
		t.right.left = new TreeNode(15);
		t.right.right = new TreeNode(7);
		System.out.println(levelOrder(t));
	}
	
	
	
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		if(root == null)
		{
			return result;
		}
		
		q.add(root);
		while(!q.isEmpty())
		{
			int size = q.size();
			List<Integer> temp = new ArrayList<>();
			for(int i=0 ; i< size ; i++)
			{
				TreeNode node = q.poll();
				temp.add(node.val);
				if(node.left != null) {q.add(node.left);}
				if(node.right != null) {q.add(node.right);}
			}
			result.add(temp);
			
		}
		return result;
		
	}
}

