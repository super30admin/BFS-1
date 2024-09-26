// Time Complexity : O(n), number of nodes in the tree
// Space Complexity : O(n), n is the number of nodes in the tree (exactly it will be O(n/2), space required to store the last level
                        //in the queue)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three Liner explanation in plain english
//1. maintain a size variable to maintain the level and start the BFS from the root node.
//2. at each level add the last node at that level in the result (the last node at each level will be visible from the right side)
//3. Continue doing this to complete the traversal of the tree

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
//DFS LEFT-ROOT-RIGHT
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //edge case
        if(root == null) return result;
        //queue to store all the childs of a node
        Queue<TreeNode> childs = new LinkedList<>();
        //add the root to the queue to start the BFS
        childs.add(root);
        //add the last node at each level in the results array
        while(!childs.isEmpty()){
            int size = childs.size();
            //to get the last node at each level
            int last = -1;
            for(int i =0; i<size; i++){
                TreeNode curr = childs.poll();
                last = curr.val;
                if(curr.left != null) childs.add(curr.left);
                if(curr.right != null) childs.add(curr.right);
            }
            result.add(last);
        }
        return result;
    }
}