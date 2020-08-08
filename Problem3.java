// There are two approaches
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

// Your code here along with comments explaining your approach
// 1. Using BFS
// Time Complexity : O(n)
//      n: number of nodes
// Space Complexity : O(n/2) = O(n)
//      n: number of nodes
class Problem3S1 {
    /**Definition for a binary tree node.*/
    class TreeNode {

        // member variable
        int val;
        // referneces
        TreeNode left;
        TreeNode right;

        // default constructor
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /** find right side using BFS */
    public List<Integer> rightSideView(TreeNode root) {
        // result
        List<Integer> result = new ArrayList<>();

        //edge case
        if(root != null){

            // queue for processing nodes in FIFO order
            Queue<TreeNode> myQueue = new LinkedList<>();
            myQueue.add(root);

            // level order traversal
            while(!myQueue.isEmpty()){
                // level
                int size = myQueue.size();
                TreeNode current = null;
                // for last node of the level(right side)
                while(size != 0){
                    
                    current = myQueue.poll();
                    if(current.left != null)
                        myQueue.add(current.left);
                    if(current.right != null)
                        myQueue.add(current.right);
                    
                    size--;
                }
                // adding last node
                if(current != null)
                    result.add(current.val);
            }
            
        }
        
        // return result
        return result;
        
    }
}

// Your code here along with comments explaining your approach
// 2. Using DFS
// Time Complexity : O(n)
//      n: number of nodes
// Space Complexity : O(h)
//      h: height of the tree
class Problem3S2 {
    /**Definition for a binary tree node.*/
    class TreeNode {

        // member variable
        int val;
        // referneces
        TreeNode left;
        TreeNode right;

        // default constructor
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // global result
    List<Integer> result; // result's size will act as height

    /** find right side view */
    public List<Integer> rightSideView(TreeNode root) {
        // intialize result
        result =  new ArrayList<>();

        // edge case
        if(root != null)
            depthFirst(root,0);
        
        // return result
        return result;
    }
    
    /** depth first traversal (on the right side) */
    private void depthFirst(TreeNode root, int level){

        // base case
        if(root != null){

            // if height is not processed
            if(result.size() == level)
                result.add(root.val);

            // increase level
            level++; 
            // go right and then left
            depthFirst(root.right, level);
            depthFirst(root.left, level);
        }
    }
}