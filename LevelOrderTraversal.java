// Time Complexity :O(N), N is the number of nodes
// Space Complexity : O(W), W is the width of the tree, max nodes at the last level
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We can traverse the tree level by level using bfs and keeping each level in the queue. Now to distinguish a level from another
// we can keep a count for number of nodes in current layer. We initialize count at every level and reduce it by one and remove
// one node from queue and add it to temp list. Once all the nodes at a level are stored in temp list, we add that temp list to the final result list.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        getLevelOrder(root, result);

        return result;
    }

    private void getLevelOrder(TreeNode root, List<List<Integer>> result) {
        int nodesInCurrentLayer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            nodesInCurrentLayer = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (nodesInCurrentLayer > 0) {
                TreeNode top = queue.poll();
                if (root.left != null) queue.add(root.left);

                if (root.right != null) queue.add(root.right);

                nodesInCurrentLayer -= 1;
                temp.add(top.val);
            }
            result.add(temp);
        }

    }
}


