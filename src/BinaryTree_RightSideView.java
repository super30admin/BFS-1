/***********************************************Using BFS******************************************/
//Time Complexity : O(n), n is the number of nodes in the tree.
//Space Complexity : O(n) , the max number of elements possible in queue are leaf nodes (i.e n/2)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/* Using BFS, keeping track of every level
 * visit nodes from left to right and for every level add the last value to the resultant array */

import java.util.*;
public class BinaryTree_RightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null)
			return result;

		Queue<TreeNode> q = new LinkedList<>();	// queue to process all nodes with processing all children at one go

		q.add(root);
		while(!q.isEmpty()){
			int size = q.size();	// size of the number of elements in queue currently (at the level)
			for(int i=0; i<size; i++){
				TreeNode curr = q.poll();	 // removing front element from queue

				if(i == size-1){    // last node of the level	// if (i == 0), taking the very first node will be left side view
					result.add(curr.val);
				}
				if(curr.left != null)
					q.add(curr.left);
				if(curr.right != null)
					q.add(curr.right);
			}
		}
		return result;
	}
}

/***********************************************Using DFS******************************************/
//Time Complexity : O(n), n is the number of nodes in the tree.
//Space Complexity : O(h) recursion stack space, h is the height of the tree
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)
            return result;
        
        dfs(root, 0 );
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        //base condition
        if(root == null)
            return;
      
        /**********If we choose to traverse right first******/
        //logic
//         if(level == result.size())
//             result.add(root.val);
        
//         dfs(root.right, level + 1);
//         //st.pop() happens here
//         dfs(root.left, level + 1);
        
        /**********If we choose to traverse left first******/
        if(level == result.size())
            result.add(root.val);
        else
            result.set(level, root.val);    // we are overwriting here, O(1)
        
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);        
    }
}
