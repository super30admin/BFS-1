// Time complexity is O(N) as each node is being traversed
// space complexity is O(N) as we are using queue data structure
// This solution is submitted on leetcode
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BigN58RightSideViewUsingBFS {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		// edge case
		if (root == null)
			return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int temp = 0;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
				// if(i==size-1)
				temp = node.val;
			}
			result.add(temp);
		}
		return result;
	}
}