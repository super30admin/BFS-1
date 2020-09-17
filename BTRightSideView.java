// Time Complexity : O(n)
// Space Complexity : O(m) m=max number of elements in a level
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Concept is to apply level order traversal and store the last element of a level to get the right most element.
// starting from the root, add the root to a queue and iterate through it's size popping them out and check for the left and right children and add them to the queue.
// Add the last element to our output list and return.

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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> output = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        int size = -1;
        while(!q.isEmpty()){
            size = q.size();
            for(int i=0;i<size;i++){
                TreeNode pop = q.poll();
                if(i+1==size){
                    output.add(pop.val); 
                }
                if(pop.left!=null){
                q.add(pop.left);
                }
                if(pop.right!=null){
                q.add(pop.right);
                }
            }
        }
        return output;
    }
}