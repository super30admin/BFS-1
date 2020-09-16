// TC: O(N) since we traversing through every node in the Tree
// SC: O(H) since we use Temp list to store values of the first element in every level. Also, the recursion stack to store values.SO it is height of the tree

// We are traversing through the each level and checking if the level is same as list size, if they both are same, we add the values into the resultant list.
// if the values in the list is not same size as our level, we will add the values into our retrieve that level list values and add values into resultant list.
// For example: If we are level 0, we will add root into it result list since both level and resultant list size is 0. while adding next element, 
// if the level is same as size of result list, we add to the list or we retrieve that level and add it to that level list.

import java.util.*;

public class LevelOrder {

	public List<List<Integer>> levelOrder(TreeNode root){
		
		List<Integer> temp = new ArrayList();
		List<List<Integer>> res = new ArrayList();
		 helper(root, 0, res);
		 return res;
	}
	
	public void helper(TreeNode root, int level,	List<List<Integer>> res ) {
		
		if(root==null)
			return;
		
		if(res.size()==level) {
			 List<Integer> temp = new ArrayList();
			 temp.add(root.val);
			 res.add(new ArrayList(temp));
		}else {
			res.get(level).add(root.val);
		}
		helper(root.left, level+1, res);
		helper(root.right, level+1, res);
	}
	public static void main(String[] args) {
		
		LevelOrder lo = new LevelOrder();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(5);
		List<List<Integer>> res = lo.levelOrder(root);
		System.out.println(res);
	}
}
