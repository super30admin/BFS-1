// Time Complexity : O(n)
// Space Complexity : O(h) (for Queue)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * We use BFS here to traverse each level. To track each level,
 * we utilize a Queue data structure where we traverse only the elements from
 * 1 level at a time.
 */

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
import java.util.*;
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size(); // track each level
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode c = q.poll();
                if(c != null) {
                    temp.add(c.val);
                    if(c.left != null)
                        q.add(c.left);
                    if(c.right != null)
                        q.add(c.right);
                }
            }
            res.add(temp);
        }

        return res;
    }
}