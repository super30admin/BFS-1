/** Binary Tree Level Order Traversal
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

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
] */

// Time Complexity : O(n) since each node is processed exactly once
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach-we will be starting with BFS as we are working on level order traversal
//Level order traversal means traversing each nodes level by level and then visit its children
//in BFS, we start with the node, process each children and add children to the queue
//Data Structure- We will be using BFS using Queue as Queue is better than ArrayList and Stack
//because queue gives us FIFO so whatever nodes that we visit, we will pop out in the same sequence and time complexity of O(1)
//while for ArrayList its 0(n) because once we pop each element from the front, we keep shifting values by O(n)

//before you start with the problem, always ask the interviewer, what is the type and range of inputs

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //Result is list of list so, we will store result in ArrayList
        List<List<Integer>> result = new ArrayList<>();
        //edge case-if there is no graph; result=[]
        if(root == null) return result;
        //define queue and start adding root in the queue starting from level 0
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            //create temp list here as we are storing result at each level
            List<Integer> temp = new ArrayList<>();
            //for processing all nodes at each level, we have to find the size of queue(2^0 --> 2^1 ---> 2^2)
            int size = q.size();
            for(int i = 0; i < size; i++){
                //for each level, pop out each element
                TreeNode curr = q.poll();
                //keep adding result in temp
                temp.add(curr.val);
                //add both left and right children to the queue
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(temp);
        } 
        return result;
    }
}