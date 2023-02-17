import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

/**
 * For level order traversal, apply BFS. maintain a queue. Push root to the
 * queue. then while queue is not empty, get the size of queue and iterate till
 * then to pop queue elements and add them to a list and then add their left and
 * right children. After the iteration of size, then push the list to answer
 * list. Repeat this until queue is empty. return the answer list at the end.
 *
 */
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			ans.add(list);
		}
		return ans;
	}
}