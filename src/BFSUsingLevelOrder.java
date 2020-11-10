import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BFSUsingLevelOrder {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null)
			return result;

		Queue<TreeNode> qu = new LinkedList<>();
		qu.add(root);

		while (!qu.isEmpty()) {
			int size = qu.size(); // here I maintained a size variable bcoz for every level we need to have
									// distinct List [[3],[9,20],[]]
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode leaf = qu.poll();
				temp.add(leaf.val);
				if (leaf.left != null)
					qu.add(leaf.left);
				if (leaf.right != null)
					qu.add(leaf.right);

			}

			result.add(temp);

		}
		return result;

	}
}
