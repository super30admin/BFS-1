// Time Complexity  - O(n)
// Space Complexity - 0(h)
// Did this code successfully run on Leetcode : Yes successfully ran
// Any problem you faced while coding this : No


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	private List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();

		if (root == null)
			return res;
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);

		while (!q.isEmpty()) {

			int size = q.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				temp.add(curr.val);

				if (curr.left != null)
					q.add(curr.left);
				if (curr.right != null)
					q.add(curr.right);

			}
			res.add(temp);
		}

		return res;

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);

		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(12);

		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);

		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(6);

		root.left.right.left = new TreeNode(11);
		root.left.right.right = new TreeNode(15);

		root.right.right.left = new TreeNode(32);
		root.right.right.right = new TreeNode(40);

		LevelOrderTraversal l = new LevelOrderTraversal();
		l.levelOrder(root);

	}

}
