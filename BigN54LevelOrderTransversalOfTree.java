// Time complexity is O(N) as we are iterating through all the tree nodes.
// Space complexity is O(N) as in queue there can be all last level element which boils down to O(N)
// This solution is submitted on leetcode

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BigN54LevelOrderTransversalOfTree {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			List<Integer> res = new ArrayList<>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
				res.add(temp.val);
			}
			result.add(res);
		}
		return result;
	}
}
