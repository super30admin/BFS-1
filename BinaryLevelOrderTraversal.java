/**
 * Time Complexity - O(N), where N is the number of nodes of binary tree.
 * Space Complexity - O(N)
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		levelOrderHelper(res, root, 0);
		return res;    
    }
    
    public void levelOrderHelper(List<List<Integer>> res, TreeNode root, int level) {
		if (root == null)
			return;
		List<Integer> curr;
		if (level >= res.size()) {
			curr = new ArrayList<>();
			curr.add(root.val);
			res.add(curr);
		} else {
			curr = res.get(level); 
			curr.add(root.val); 
			//res.add(curr); // No need to add the curr into the res, because the res.get(index) method does not remove the index element
		}
		levelOrderHelper(res, root.left, level + 1);
		levelOrderHelper(res, root.right, level + 1);
	}
}
