// Time Complexity : O(n) where  n is no.of nodes
// Space Complexity : O(log h) height of binary tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*Approach
 * Used the DFS approach, iterate the tree from the right sub tree,
 * If the size of the result list is same as level of the tree wer add the element
 * in the result.
 * */


import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root==null) return result;

        dfs(root, 0);
        return result;

    }

    private void dfs(TreeNode root, int level) {

        //edge
        if(root==null) return;

        //logic
        if(result.size()==level){
            result.add(root.val);
        }
        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }

}
