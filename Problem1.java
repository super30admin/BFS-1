package BFS1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Using BFS with the help of a Queue to traverse level by level and at each node the left child is added first so that
 * when we process the nodes we go from left to right at each level
 * 
 * Time Complexity : O(n) where n is the no of nodes
 * 
 * 
 * Space Complexity : O(n) since we use a queue
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */

class TreeNode {
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
 
public class Problem1 {

	    public List<List<Integer>> levelOrder(TreeNode root) {

	        Queue <TreeNode> q =new LinkedList<>();
	        List<List<Integer>> ans = new ArrayList<List<Integer>>();
	        if(root==null){
	            return ans;
	        }
	        q.add(root);

	        while(!q.isEmpty()){
	            int size=q.size();
	            List<Integer> levelOrder= new ArrayList<Integer>();
	            for(int i=0;i<size;i++){
	                TreeNode curr=q.poll();
	                levelOrder.add(curr.val);
	                if(curr.left!=null)
	                    q.add(curr.left);
	                if(curr.right!=null)
	                    q.add(curr.right);
	            }

	            ans.add(levelOrder);

	        }
	        return ans;
	    }
}
