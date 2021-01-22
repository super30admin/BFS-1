//Time Complexity: O(N) 
//Space Complexity: O(N)

//Successfully runs on leetcode : 0 ms

//Approach: We do BFS traversal here by traversing every level and storing the node values in a separate list corresponding to
//each level. The BFS is performed using queue data structure and the levels are maintained using the size variable.


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
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < size; i++)
            {
                TreeNode q = queue.poll();
                res.add(q.val);
                if(q.left != null) queue.add(q.left);
                if(q.right != null) queue.add(q.right);
            }
            result.add(res);
        }
        return result;
    }
}