import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideUsingBFS {
	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> qu = new LinkedList<>();
		qu.add(root);
		int last = -1;
		while (!qu.isEmpty()) {

			int size = qu.size();

			for (int i = 0; i < size; i++) {
				TreeNode curr = qu.poll();
				last = curr.val;

				if (curr.left != null)
					qu.add(curr.left);
				if (curr.right != null)
					qu.add(curr.right);
			}
			result.add(last);

		}

		return result;

	}
}
