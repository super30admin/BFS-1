// Time Complexity : O(n) //n nodes that we are traversing
// Space Complexity : O(n) ~ O(n/2) : At leaf, we have n/2 nodes in queue which is O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yeah, condition check issues.

//Take queue and keep adding nodes.
//Maintain size of queue for knowing at each node how many TreeNodes are there as this is not balanced binary tree
//While polling from queue, add its left and right node and continue this process till the end.

//This is BFS traversal of tree.

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
    
    List<List<Integer>> result = new ArrayList<>();   
    public List<List<Integer>> levelOrder(TreeNode root) {    
        dfs(root, 0);     
        return result;
    }

    private void dfs(TreeNode root, int level){
        
        //base
        if(root == null) // Add an empty list to listOfLists
            return ;

        //pre-order : This has to be pre-order

        //logic
        if(result.size() == level){
            result.add(new ArrayList<Integer>());
        }

        result.get(level).add(root.val);

        dfs(root.left, level+1);
        //Node can be added to list in inorder level. 
        //precondition of having list has to be satisfied.
        dfs(root.right, level+1);
    }
}