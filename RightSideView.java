// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class BFSSolution {
		public List<Integer> rightSideView(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			if (root == null)
				return result;
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					TreeNode node = q.poll();
					if (i == 0)
						result.add(node.val);
					if (node.right != null)
						q.add(node.right);
					if (node.left != null)
						q.add(node.left);
				}
			}
			return result;
		}
	}
}
