package binaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Time: O(numNodes)
 * Space: O(1)
 * Leetcode Accepted: yes
 * Problems faced: NA
 */
public class RightSideView {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		System.out.println(rightSideView(root));
	}
	
	//Using BFS Level Order Traversal Algorithm
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int count = q.size();
			for(int i=0; i<count; i++) {
				TreeNode curr = q.remove();
				//The first value in any level gives the right most view 
				if(i==0) result.add(curr.val);
				//Always insert right first followed by left
				if(curr.right != null) {
					q.add(curr.right);
				} 
				if(curr.left != null){
					q.add(curr.left);
				}
			}
		}
		return result;
    }
}
