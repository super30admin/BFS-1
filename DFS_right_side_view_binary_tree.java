// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity :O(n), where n is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I always get confused, if I should say time complexity as O(h) or O(n). Like I 
                                            // got it that in case of a skwed tree h == n.
                                            //But my question is it right to say, in time complexity "n" is number of nodes in the
                                            //tree and in space complexity "n" is the height of the tree
                                            //Is it correct to change the definition of "n" in Time and space complexity??


//Three liner explanation of your code in plain english
//1. create a list(result) to store only 1 node at each level. Start dfs at root node maintaining level at each node.
//2. check if you have added a node for that level in the result, if not then add, else replace the element in the result at the index
        //equal to level, with the current node's value
//3. as we are going from left to right in DFS, the result will only have node at each level that are visible from the right side.
        //Return the result once the complete tree is traversed

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
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        //edge case
        if(root == null) return result;
        //call dfs on the root node, with level 0
        dfs(root, 0);
        //once the entire tree is traversed return the result
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        //basic
        if(root == null) return;
        //logic
        //at any level only one node will be stored (as you can only see 1 node at any level from right side)
        if(level == result.size()){
            result.add(root.val);
        }
        else{
            result.set(level, root.val);
        }
        
        //explore left subtree
        dfs(root.left, level+1);
        //stack.pop()
        //go the right child
        dfs(root.right, level+1);
    }
}