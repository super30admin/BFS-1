
time complexity: O(n)
space complexity: O(n)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
	
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> l = new ArrayList<>(size);

			for (int i = 0; i < size ; i++) {
				TreeNode n = queue.remove();
				l.add(n.val);

				if (n.left != null)
					queue.add(n.left);
				if (n.right != null)
					queue.add(n.right);
			}
			
			result.add(l);
		}

		return result; 
    }
}
