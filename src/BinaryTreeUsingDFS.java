import java.util.ArrayList;
import java.util.List;

public class BinaryTreeUsingDFS {
	List<List<Integer>> result;

	public List<List<Integer>> levelOrder(TreeNode root) {
		result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;

		dfs(root, 0);
		return result;
	}

	private void dfs(TreeNode root, int level) {
		// TODO Auto-generated method stub
		// base
		if (null == root)
			return;
		// logic
		if (level == result.size()) {
			result.add(new ArrayList<Integer>());
		}
		result.get(level).add(root.val);
		dfs(root.left, level + 1);
		//st.pop();
		dfs(root.right, level + 1);

	}
}
