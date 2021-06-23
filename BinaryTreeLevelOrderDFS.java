// Time Complexity : O(N)
// Space Complexity : O(H) //number of level variables in the stack 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Do the pre order traversal.
 * 2. For the recursive method send current level as input.
 * 3. For each level create a new list and after the level add it to result.
 * 4. add root value to the list and return it as output.
 */


import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderDFS {
	private List<List<Integer>> result = new ArrayList<>();
	
	 public List<List<Integer>> levelOrder(TreeNode root) {
		 helper(root,0);
		 return result;
	 }
	 
	 private void helper(TreeNode root,int level) {
		 if(root==null) return;
		 
		 if(result.size()==level) {
			 result.add(new ArrayList<Integer>());
		 }
		 result.get(level).add(root.val);
		 
		 helper(root.left,level+1);
		 helper(root.right,level+1);
		 
	 }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
