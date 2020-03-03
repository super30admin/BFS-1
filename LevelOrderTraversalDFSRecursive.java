// Time Complexity  - O(n) 
// Space Complexity - 0(1)
// Did this code successfully run on Leetcode : Yes successfully ran
// Any problem you faced while coding this : No


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalDFSRecursive {
	List<List<Integer>> res ;

	private List<List<Integer>> levelOrder(TreeNode root) {
		res = new ArrayList<>();
		if(root == null) return res;
		helper(root, 0);
		return res;	

	}

	
	private void helper(TreeNode root, int level) {
		
		if(root==null)
			return;
		
		if(res.size() == level) {
			res.add(new ArrayList<>());
		}
		
		res.get(level).add(root.val);
		helper(root.left, level+1);
		helper(root.right, level+1);
		
	}
	
	
	public static void main(String[] args) {

		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);

		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(12);

		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);

		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(6);

		root.left.right.left = new TreeNode(11);
		root.left.right.right = new TreeNode(15);

		root.right.right.left = new TreeNode(32);
		root.right.right.right = new TreeNode(40);

		LevelOrderTraversalDFSRecursive l = new LevelOrderTraversalDFSRecursive();
		l.levelOrder(root);

	}

}
