package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue; 

/**
 * Time: O(n)
 * Space: O(n)
 * Leetcode accepted: yes
 * Problems faced: NA
 */
public class LevelOrderTrversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3); 
        root.left = new TreeNode(9); 
        root.right = new TreeNode(20); 
        root.right.left = new TreeNode(15); 
        root.right.right = new TreeNode(7); 
        System.out.println(levelOrder(root));
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			List<Integer> set = new ArrayList<Integer>();
			//Keep the counter to segregate the levels
			int count = q.size();
			for(int i=0; i<count; i++) {
				TreeNode curr = q.poll();
				if(curr.left != null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);
				set.add(curr.val);
			}
			result.add(set);
		}
		return result;
	}
}
