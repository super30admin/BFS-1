// Time Complexity : O(n)), size of queue
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package bfs1;

import java.util.*;

public class DFSLevelOrder {

    List<List<Integer>> res;

    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, 0);
        return res;
    }

    void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
        res.get(level).add(root.val);
    }
}
