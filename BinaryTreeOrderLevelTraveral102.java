package dec142020;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeOrderLevelTraveral102 {

	// Definition for a binary tree node.
	public class TreeNode {
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

	List<List<Integer>> result;

	public List<List<Integer>> levelOrder(TreeNode root) {
		result = new ArrayList<>();
		if (root == null)
			return result;
		dfs(root, 0);
		return result;
	}

	private void dfs(TreeNode root, int level) {
		if (root == null)
			return;
		if (level == result.size()) {
			result.add(new ArrayList<>());
		}
		result.get(level).add(root.val);
		dfs(root.left, level + 1);
		dfs(root.right, level + 1);
	}
}

// time complexity O (N)
// Space complexity O (N)