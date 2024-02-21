// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        if (root == null) {
            return results;
        }

        // helperQueue(root, results);
        helperRecurrsionPreOrder(root, results, 0);
        return results;
    }

    // private void helperQueue(TreeNode root, List<List<Integer>> results) {

    //     Queue<TreeNode> que = new LinkedList<>();
    //     que.offer(root);

    //     while (!que.isEmpty()) {
    //         int level = que.size();

    //         List<Integer> list = new ArrayList<>();
    //         for (int i = 0; i < level; i++) {
    //             TreeNode node = que.poll();
    //             list.add(node.val);

    //             if (node.left != null) {
    //                 que.offer(node.left);
    //             }

    //             if (node.right != null) {
    //                 que.offer(node.right);
    //             }
    //         }
    //         results.add(list);
    //     }
    // }

    private void helperRecurrsionPreOrder(TreeNode root, List<List<Integer>> results, int level) {
        if (root == null) {
            return;
        }

        if (level == results.size()) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            results.add(list);
        } else {
            results.get(level).add(root.val);
        }
        if (root.left != null) {
            helperRecurrsionPreOrder(root.left, results, level + 1);
        }

        if (root.right != null) {
            helperRecurrsionPreOrder(root.right, results, level + 1);
        }
    }
}