/*
 * #199. Binary Tree Right Side View
 * 
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
  
 */


/*
 * Time Complexity: O (N) -> To visit/traverse 'N' number of nodes in a tree
 * 
 * Space Complexity: O (N) -> To store 'N' nodes of a tree,  not at the same time but level by level
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
class TreeNode7 {
	int val;
	TreeNode7 left;
	TreeNode7 right;
	TreeNode7() {}
	TreeNode7(int val) { this.val = val; }
	TreeNode7(int val, TreeNode7 left, TreeNode7 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}


public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode7 root) {
        // #1. Create an empty list to store the output
        List<Integer> list = new ArrayList<>();
        
        // #2. Base condition
        // If root is null, no level order traversal, so return empty list as output
        if(root == null){
            return list;
        }
        
        // #3. Create a queue using Linked List
        Queue<TreeNode7> q = new LinkedList<TreeNode7>();
        
        // #4. Initiate the queue with root element
        // Add root to the queue
        q.add(root);
        
        // #5. Traverse through the queue elements until it is empty
        while(!q.isEmpty()){
            // #6. To know how many elements exists at current level, we need to get length of a queue for that level
            int levelLength = q.size();
            
            // #7. Traverse through nodes at a particular level -> no of nodes = length of a queue
            for(int i = 0; i < levelLength; i++){
                // #8. Remove the front element from a queue
                TreeNode7 front = q.remove();
                
                // #9. Check if we are at the last iteration of for loop -> rightmost node at current level
                if(i == levelLength - 1){
                    // #10. Add the node value to output list
                    list.add(front.val);
                }
                
                // #11. If not at the last iteration -> not the rightmost node at current level, go to next level and add front node's left and right child in queue
                if(front.left != null){
                    q.add(front.left);
                }
                
                if(front.right != null){
                    q.add(front.right);
                }
                
            } // for loop to traverse nodes at current level
            
        } // stop when queue is empty 
        
        return list; // return the output
        
    }
    
}
