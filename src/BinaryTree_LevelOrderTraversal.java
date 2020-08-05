import java.util.*;

//Definition for a binary tree node.
class TreeNode {
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
/******************************Approach 1: Using BFS*************************************/
//Time Complexity :O(n), n is the number of nodes in the tree.
//Space Complexity : O(n) , the max number of elements possible in queue are leaf nodes (i.e n/2)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/*Using Queue every level is added to temporary list and
 *  temp list is added to the resultant list*/

public class BinaryTree_LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if(root == null)
			return result;

		// to process the nodes in FIFO manner, queue is used
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()){
			List<Integer> list = new ArrayList<>(); // inner list, creates a list at each level
			int size = queue.size();    // to calculate the size of the queue at current level

			for(int i=0; i<size; i++){  // processing elements of current level
				TreeNode curr = queue.poll();   // to return the front element out of the queue
				list.add(curr.val);

				if(curr.left != null)
					queue.add(curr.left);

				if(curr.right != null)
					queue.add(curr.right);
			}
			result.add(list);   // add the resultant list to final result list
		}
		return result;   
	}
}

/******************************Approach 2: Using DFS*************************************/

//Time Complexity :O(n), n is the number of nodes in the tree.
//Space Complexity : O(h) recursion stack space, h is the height of the tree
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/*Recursive approach, where a dfs is called on every
element and for every level append the element to the respective list */

public class BinaryTree_LevelOrderTraversal {
	List<List<Integer>> result;
	public List<List<Integer>> levelOrder(TreeNode root) {
		result = new ArrayList<>();

		if(root == null)
			return result;

		dfs(root, 0);   /// call to dfs function on root for level 0

		return result;
	}

	private void dfs(TreeNode root, int level){
		// base condition
		if(root == null)
			return;

		// logic
		if(level == result.size())  //if there is no list in result for current level, add an empty list
			result.add(new ArrayList<>());

		result.get(level).add(root.val);    // adding current root value to result at that level

		// st.pop() happens here
		dfs(root.left, level + 1);
		dfs(root.right, level + 1);
	}
}