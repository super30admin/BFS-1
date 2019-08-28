package BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


//Recursive 
//Time Complexity - O(n)
//Space Complexity - O(Depth of the tree)

class BinaryTreeRightSideView {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		helper(root, 0, result);
		return result;
	}

	private void helper(TreeNode node, int depth, List<Integer> result) {
		if(node == null) return;
		if(depth == result.size()) result.add(node.val);
		helper(node.right, depth+1, result);
		helper(node.left, depth+1, result);
	}
}


//Iterative 
//Time Complexity - O(n)
//Space Complexity - O(n)

class BinaryTreeRightSideView {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int count = queue.size();
			for(int i=0; i<count; i++) {
				//Add children of each node, if present
				TreeNode node = queue.poll();
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
				//Find the last element from the queue to be added to the result list
				if(i == count-1)
					result.add(node.val);
			}
		}
		return result;
	}
}