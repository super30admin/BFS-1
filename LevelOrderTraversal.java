/*
 * #102. Binary Tree Level Order Traversal
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
   
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]

 */


/*
 * Time Complexity: O (N) -> We are visiting all the nodes at each level in a tree one by one
 * 
 * Space Complexity: O (N) -> We are adding nodes at current level to the queue, and we are doing this for all levels in a a tree, so O (N)
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.BFS1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Definition for a binary tree node.
class TreeNode6 {
	int val;
	TreeNode6 left;
	TreeNode6 right;
	TreeNode6() {}
	TreeNode6(int val) { this.val = val; }
	TreeNode6(int val, TreeNode6 left, TreeNode6 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class LevelOrderTraversal {
	 public List<List<Integer>> levelOrder(TreeNode6 root) {
	        // #1. Create a resultant list -> final output
	        List<List<Integer>> result = new ArrayList<>();
	        
	        // #2. Create a Queue using LL 
	        Queue<TreeNode6> queue = new LinkedList<>();
	        
	        // Base condition
	        // If root is null, no binary tree. Return empty list as output
	        if(root == null){
	            return result;
	        }
	        
	        // Else
	        // #3. Initiate a queue by adding root node to it
	        queue.add(root);
	        
	        // #4. Traverse through the queue elements until it is empty
	        while(!queue.isEmpty()){
	            // #5. Compute length of queue at current level to know number of nodes at that particular level
	            int levelLength = queue.size();
	            // #6. Create an empty list at each level to store nodes at that level
	            List<Integer> list = new ArrayList<>(); 
	            
	            // #7. Traverse all the nodes at current level in a queue one by one
	            for(int i = 0; i < levelLength; i++){
	                // for each node at current level
	                
	                // Remove the node from queue
	                TreeNode6 front = queue.remove();
	                
	                // Add the node to list
	                list.add(front.val);
	                
	                // Check if left and right childs of that node exists, if yes add them to queue
	                if(front.left != null){
	                    queue.add(front.left);
	                }
	                
	                if(front.right != null){
	                    queue.add(front.right);
	                }
	                   
	            }
	            
	            // Add the list with nodes at current level to final result list
	            result.add(list);
	        }
	        
	        // Once queue is empty, done with all the levels in a tree
	        return result; // final list
	        
	    }
	 
}
