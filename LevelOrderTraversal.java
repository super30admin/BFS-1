package BFS1;
// Time Complexity : O(n)
// Space Complexity : O(h) height of tree
// Did this code successfully run on Leetcode : yes


import Trees1.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int level){
        if(root == null)
            return;
        if(result.size()==level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
