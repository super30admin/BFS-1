package bfs1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
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
	
	//BFS
	//Time Complexity : O(n), where n is the elements of tree
	//Space Complexity : O(n), for queue
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.val);
                
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
            res.add(list);
        }
        return res;
    }
	
	//DFS
	//Time Complexity : O(n), where n is the elements of tree
	//Space Complexity : O(h), height for recursion stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        helper(root, res, 0);
        return res;
    }
    
    private void helper(TreeNode root, List<List<Integer>> res, int level) {
        // base
        if(root == null)
            return;
        
        // logic
        if(res.size() == level)
            res.add(new ArrayList<>());
        res.get(level).add(root.val);
        
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}
