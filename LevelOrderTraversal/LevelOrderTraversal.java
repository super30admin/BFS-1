import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Time Complexity - O(n)
//Space Complexity - O(n)

class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		
		List<List<Integer>> result = new ArrayList<>();
		
		if(root == null) return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			int count = queue.size();

			for(int i = 0; i < count; i++) {

				TreeNode node = queue.poll();
				temp.add(node.val);

				if(node.left != null)
					queue.add(node.left);
				
				if(node.right != null)
					queue.add(node.right);
			}
			result.add(temp);
		}
		return result;
	}
}