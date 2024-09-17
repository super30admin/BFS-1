
// Time Complexity : O(N)
// Space Complexity : O(H), H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

public class Level_Order_Traversal_DFS {
	List<List<Integer>> result;

	public List<List<Integer>> levelOrder(TreeNode root) {
		result = new ArrayList<>();
		if (root == null)
			return result;
		helper(root, 0);
		return result;
	}

	private void helper(TreeNode root, int level) {
		// base
		if (root == null)
			return;
		// logic
		if (result.size() == level) {
			result.add(new ArrayList<>());
		}
		result.get(level).add(root.val);
		helper(root.left, level + 1);
		helper(root.right, level + 1);
	}
}
