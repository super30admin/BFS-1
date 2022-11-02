// TC : O(n)
// SC : O(n)
// Ran on LC : Yes
// Problems : None.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	List<List<Integer>> res;
	public List<List<Integer>> levelOrder(TreeNode root) {
		 res = new ArrayList<>();
		 
		 if (root == null) return res;
		 
		 // BFS approach
		 Queue<TreeNode> q = new LinkedList<>();
		 
		 q.add(root);
		 
		 while(!q.isEmpty()) {
			  List<Integer> list = new ArrayList<>();
			  int size = q.size();
			  for(int i = 0; i < size; i++) {
					TreeNode curr = q.poll();
					if(curr.left != null) q.add(curr.left);
					if(curr.right != null) q.add(curr.right);
					
					list.add(curr.val);
			  }
			  res.add(list);
		 }
		 // dfs(root, 0);
		 return res;
	}
	
	// O(n)
	// O(h)... worst O(n)
	// DFS approach
	private void dfs(TreeNode root, int depth) {
		 //base
		 if(root == null) return;
		 //logic
		 if(depth == res.size()) {
			  res.add(new ArrayList<>());
		 }
		 res.get(depth).add(root.val);
		 
		 dfs(root.left, depth+1);
		 dfs(root.right, depth+1);
	}
}