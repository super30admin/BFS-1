// TC: O(H) since we are traversing only height of the tree
// SC: O(1) because of the constant space usage.

// We traverse through the tree and and check for the right most element, if the element on the right is found and we check if the elements in the list is equals to level size
// we add the right element into the list. if we dont find our element on right side of tree, we traverse through the left side, and if the list size is same of our level size,
// we add the left node in the list. So, this way we are adding every last node in every level.


import java.util.*;

public class RightSideTree {

	public List<Integer> rightView(TreeNode root) {
		
		List<Integer> res = new ArrayList();
		 helper(root, 0, res);
		 return res;
	}
	
	public void helper(TreeNode root, int level, List<Integer> res) {
		
		if(root==null)
			return;
		
		if(res.size()==level) {
			res.add(root.val);
		}
		
		helper(root.right, level+1, res);
		helper(root.left, level+1, res);
	}
	
	public static void main(String[] args) {
		
		RightSideTree rst = new RightSideTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(4);
		List<Integer> res = rst.rightView(root);
		System.out.println(res);
	}
}
