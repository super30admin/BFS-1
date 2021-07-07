package s30Coding;
import java.util.*;

//Time Complexity :- O(h) height of the tree
//Space Complexity :- O(h) height of the tree
//LeetCode :- Yes
//Logic :- dfs

public class RightSideViewBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	 public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> result = new ArrayList<>();
	        if(root == null) return result;
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        while(!q.isEmpty()){
	            int size = q.size();
	            int last = -1;
	            for(int i = 0; i < size; i++){
	                TreeNode curr = q.poll();
	                last = curr.val;
	                if(curr.left !=null) q.add(curr.left);
	                if(curr.right !=null) q.add(curr.right);
	            }
	            result.add(last);
	        }
	        return result;
	        
	    }
}
