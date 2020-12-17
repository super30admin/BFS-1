package codes;

public class Level_order_traversal {
	  public List<List<Integer>> levelOrder(TreeNode root) {
  		List<List<Integer>> a = new ArrayList();
	if (root != null) {
		
		List<Integer> aforroot = new ArrayList();
		int scroller = 0;
		levelorder(root, a, scroller);
	}

	return a;
}
	public void levelorder(TreeNode root1, List<List<Integer>> a, int scroller) {
	if (root1 != null && root1.left != null || root1.right != null) {
	
		if(scroller >= a.size()) {
			List<Integer> aforroot = new ArrayList();
			a.add(aforroot);		
		}
	}
	if (root1.left != null) {

		if (root1.left != null) {
			levelorder(root1.left, a, scroller + 1);
		} else {

		}
	}
	if (root1.right!= null) {

		if (root1.right != null) {
			levelorder(root1.right, a, scroller + 1);
		} else {

			return;
		}
	}

	if (scroller - 1 >= 0) {
		a.get(scroller - 1).add(root1.val);
	} else {
		List<Integer> aforroot = new ArrayList();
		aforroot.add(root1.val);
		a.add(0, aforroot);
	}
	return;
}
}
