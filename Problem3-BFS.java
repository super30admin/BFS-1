/** Binary Tree Right Side View - BFS Approach
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <--- */

  // Time Complexity : O(n) as it traverses each node exactly once
// Space Complexity : O(n) as we are putting each element/node in a queue taking O(n) space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//approach- We can work with BFS or DFS both
//BFS Approach- we start with level order traversal. so we will consider the last element at each level and store in the result
//the final result list will provide us with right side view. For this we are going to initialise queue and keep queue size in the for loop
//as its getting mutated every time once we push our elements level by level

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
       //create a result arraylist to store final result(right side view)
       List<Integer> result = new ArrayList<>();
       //edge case(please include this as it makes solution asymptotically faster)
       //edge-if graph doesn't exist
       if(root == null) return result; //result =[]
       //initialise queue for BFS as its FIFO operation; keep the type as TreeNode
       Queue <TreeNode> q = new LinkedList<>();
       //adding the root value first to the queue
       q.add(root);
       //keep adding elements at each level until the queue becomes empty
       while(!q.isEmpty()){
           //intialise size of queue at each level
           int size = q.size();
           Integer temp = null;
           //iterate all the elements at each level
           for(int i = 0; i < size; i++){
               //popping the current element
               TreeNode curr = q.poll();
               //assigning current value to temp
               //this will help us to get right side view; for getting left side view use if(i == 0) temp = curr.val
               temp = curr.val;
               if(curr.left != null) q.add(curr.left);
               if(curr.right != null) q.add(curr.right);
           }
           result.add(temp);
       }
       return result;
 }
}
