
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

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

class Level_Order_Traversal_BFS {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> list = new LinkedList<>();
		list.add(root);
		while (!list.isEmpty()) {
			int size = list.size();
			List<Integer> temp = new ArrayList<>();
			// level process
			for (int i = 0; i < size; i++) {
				TreeNode curr = list.poll();
				temp.add(curr.val);
				if (curr.left != null)
					list.add(curr.left);
				if (curr.right != null)
					list.add(curr.right);
			}
			result.add(temp);
		}
		return result;
	}
}