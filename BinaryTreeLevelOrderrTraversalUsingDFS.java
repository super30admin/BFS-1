package BFS1;

// Time Complexity : O(n)
// Space Complexity : O(h)   //h is the height of the tree;
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderrTraversalUsingDFS {

    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int level)
    {
        if(root == null) return;
        if(level == result.size())
        {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);
        level++;

        helper(root.left, level);
        helper(root.right, level);
    }
}
