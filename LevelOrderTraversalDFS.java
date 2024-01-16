/*
* Approach:
*  1. Initialize the result array based on level.
* 
*  2. In DFS, first we explore any of the children and go by levels.
        While exploring levels, initialize the levels array in result based on size.

        if level == result.size() -> not initialized.
        else add the root value
* 
*  3. Process the left and right children
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(N)
    N = Nodes
* 
* Space Complexity: O(H)
    H = Height of the tree
* 
*/


import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversalDFS {
    List<List<Integer>> result = new ArrayList<>();

    private void helper(TreeNode root, int level){
        if(root == null)
            return;

        // current level array is not initialized
        if(result.size() == level){
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        helper(root.left, level+1);
        helper(root.right, level+1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);

        return result;
    }
}
