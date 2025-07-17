// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) for the queue and result list in the worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I used a queue - added the root and maintained a level size, at each level, from left to right, I remove the node and add its value to the current level list - I also add the children to the queue - these will not be in the list as I use the level size to iterate through the current level nodes only.

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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  
            List<Integer> currList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                currList.add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            result.add(currList);
        }
        return result;
    }
}
