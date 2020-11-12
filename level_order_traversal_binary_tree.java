// Time Complexity : O(n), where n is the number of nodes in the binary tree
// Space Complexity :O(n), where n is the height of the tree (int the worst case the height will O(n/2) (nodes in the last level))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three Liner Expalanation of your code in plain English
//1. Create a Queue, start the BFS from the root by adding the root node in the queue
//2. Maintain a size variable (defining all the nodes at that level), remove all the nodes at that level and add them in a temp list
        //while adding all the childs of the nodes at that level in the queue
//3. Now temp has all the nodes at that level, so add the list temp to the result. Keep doing this till all levels are traversed and 
        // in the end return the result(list of lists)

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //for returning the result
        List<List<Integer>> result = new ArrayList<>();
        //edge case
        if(root == null) return result;
        //queue to store all the childers of a node to be processed
        Queue<TreeNode> childs = new LinkedList<>();
        
        //put the root in the queue to start BFS
        childs.add(root);
        
        //till all the nodes are not traversed
        while(!childs.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            //maintaina size variable to identify all the nodes at that level
            int size = childs.size();
            //put all the nodes at that level in the temp and thier left and right childs in the childs queue to be processed
            for(int i =0; i<size; i++){
                TreeNode curr = childs.poll();
                if(curr.left != null) childs.add(curr.left);
                if(curr.right != null) childs.add(curr.right);
                temp.add(curr.val);
            }
            //add all the nodes at that level as a seperate list in the result
            result.add(temp);
        }
        //return the list of lists
         return result;
    }
}