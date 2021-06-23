// Time Complexity : O(N)
// Space Complexity : O(N) //queue will have only one level elements that is max n/2 at leaf level.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Starting from the root add nodes to queue.
 * 2. visit the nodes in that level and for each node add its child's into queue.
 * 3. For each level create a new list and after the level add it to result.
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderBFS {
	
	 public List<List<Integer>> levelOrder(TreeNode root) {
		 List<List<Integer>> result = new ArrayList<>();
		 if(root==null) return result;
		 Queue<TreeNode> queue= new LinkedList<>();
		 queue.add(root);
		 
		 while(!queue.isEmpty()) {
			 int count = queue.size();
			 List<Integer> rowList= new ArrayList<>();
			 
			 for(int i=0;i<count;i++) {
				 TreeNode node=queue.poll();
				 rowList.add(node.val);
				 if(node.left!=null) {
					 queue.add(node.left);
				 }
				 if(node.right!=null) {
					 queue.add(node.right);
				 }
			 }
			 result.add(rowList);
		 }
		 return result;
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
