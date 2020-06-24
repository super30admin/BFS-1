//BFS
// Time Complexity : O(n)
// Space Complexity :O(2^h), where h is the height of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Approach
//1) Maintain queue and a size variable to determine level
//2) So, pop each element from queue and add their children to the queue
//3) At each level add the elements to curr

//DFS
// Time Complexity : O(n)
// Space Complexity :O(h), where h is the height of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Approach
//1) Call the recursion with node and level variable at each node, maintain result list globally
//2) If the size of result = level of the popped node, then add a new list to result 
//3) add root values to result if that level list is present in result.
//4) recursively call left and then right
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class BTRightView {
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
	
	List<Integer> result;
    //bfs
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size(); int last = -1;
            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                last = curr.val;
                if(curr.left != null)queue.add(curr.left);
                if(curr.right != null)queue.add(curr.right);
            }
            result.add(last);
        }
        return result;
    }
    //dfs
    public List<Integer> rightSideView1(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)return result;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root == null)return;
        
        if(result.size()== level){
            result.add(root.val);
        }
        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}
