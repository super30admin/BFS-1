// There are two approaches
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// Your code here along with comments explaining your approach
// Time Complexity : O(n) 
//      n: number of nodes in tree
//      h: height of the tree
//    Generalized: O(2^(h+1)-1)
// Space Complexity : O(n/2) = O(n)
//      n: number of nodes in tree
//    We require a queue of max size of n/2
//    That is the number of nodes at the last level
//   Generalized: O((2^(h+1)-1)/2)
class Problem1S1 {
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
    /** level order travesal -BFS */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // result
        List<List<Integer>> result = new ArrayList<>();

        // not null
        if(root != null){

            // for processing in FIFO order
            Queue<TreeNode> myQueue = new LinkedList<>();
            myQueue.add(root);

            // traversing
            while(!myQueue.isEmpty()){
                // temp
                List<Integer> tempResult = new ArrayList<>();

                // process elements belonging to same level
                int size = myQueue.size();
                while(size!=0){

                    // removing from the queue
                    TreeNode current = myQueue.poll();
                    tempResult.add(current.val);

                    // processing children
                    if(current.left != null)
                        myQueue.add(current.left);
                    if(current.right != null)
                        myQueue.add(current.right);
                    
                    size--;
                }
                // adding to result
                result.add(tempResult); 
            }  
        }
        // return result
        return result;
    }
}
// Your code here along with comments explaining your approach
// Time Complexity : O(n) 
//      n: number of nodes in tree
//    Generalized: O(2^(h+1)-1)
// Space Complexity : O(h)
//      h: height of the tree
//      recursive stack
class Problem1S2 {
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
    List<List<Integer>> result;
    
    /** return level order using DFS */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // intilaize
        result = new ArrayList<>();
        // edge case
        if(root !=  null){
            depthFirstTraversal(root, 0);
        }

        // return result
        return result;
    }
    /** DFS */
    private void depthFirstTraversal(TreeNode root, int level){
        // base case
        if(root != null){
            
            // create new arraylist and add to result
            if(result.size() == level)
                result.add(new ArrayList<Integer>());
            
            // process root
            result.get(level).add(root.val);
            
            // go left and right
            depthFirstTraversal(root.left, level+1);
            depthFirstTraversal(root.right, level+1);
        }

    }
}