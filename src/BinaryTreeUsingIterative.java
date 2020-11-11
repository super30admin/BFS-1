import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeUsingIterative {

	List<List<Integer>> result;

	public List<List<Integer>> levelOrder(TreeNode root) {
		result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;

		
		Stack<Pair> st = new Stack<>();
		int level = 0;
		while (root != null || !st.isEmpty()) {
			while (root != null) {
				Pair p = new Pair();
				if (result.size() == p.getLevel()) {
					result.add(new ArrayList<Integer>());
				}
				result.get(p.getLevel()).add(root.val);
				st.add(new Pair(root, level + 1));
				root = root.left;
			}
			Pair p = st.pop();
			root = p.keyNode;
			if (root.left != null)
				level++;
			if (root.right != null)
				level++;
			root = root.right;
		}
		return result;

	}

	public static void main(String[] args) {
		TreeNode left1 = new TreeNode(15, null, null);
		TreeNode right1 = new TreeNode(7, null, null);
		TreeNode right = new TreeNode(20, left1, right1);
		TreeNode left = new TreeNode(9, null, null);
		TreeNode root = new TreeNode(3, left, right);

		BinaryTreeUsingIterative iter = new BinaryTreeUsingIterative();
		iter.levelOrder(root);

	}
}
