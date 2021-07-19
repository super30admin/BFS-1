//Time Complexity : O(n), n -> Number of nodes in the tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int len = queue.size();

			List<Integer> levelNodes = new ArrayList<Integer>();
			for (int i = 0; i < len; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				levelNodes.add(node.val);
			}
			ans.add(levelNodes);
		}
		return ans;
	}

	public static void main(String[] args) {
		LevelOrderTraversal obj = new LevelOrderTraversal();

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		List<List<Integer>> ans = obj.levelOrder(root);

		System.out.println("Level order traversal of tree: ");

		for (List<Integer> level : ans) {
			for (Integer node : level) {
				System.out.print(node + " ");
			}
			System.out.println();
		}
	}

}
