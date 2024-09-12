import java.util.ArrayList;
import java.util.List;

public class RightSideUsingDFS {
	List<Integer> result = new ArrayList<>();

	public List<Integer> rightSideView(TreeNode root) {

		if (root == null)
			return result;

		dfs(root, 0);

		return result;
	}

	private void dfs(TreeNode root, int level) {
		// TODO Auto-generated method stub

		// base
		if (root == null)
			return;

		// logic
		if (result.size() == level) // if there are no new element on the level insert the new element
			result.add(root.val);
		else {
			result.set(level, root.val); // if there is already left value element present then replace that with right
											// value element with that index pos
		}

		dfs(root.left, level + 1);
		dfs(root.right, level + 1);

	}

}
