
// Time Complexity : O(N)
// Space Complexity : O(H), H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

public class Right_View_DFS {
	List<Integer> result;

	public List<Integer> rightSideView(TreeNode root) {
		result = new ArrayList<>();
		DFS(root, 0);
		return result;
	}

	private void DFS(TreeNode root, int level) {
		// base
		if (root == null)
			return;

		// logic
		if (result.size() == level) {
			result.add(root.val);
		}
		DFS(root.right, level + 1);
		DFS(root.left, level + 1);
	}
}