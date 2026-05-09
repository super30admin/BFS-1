// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) where n is the number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach
// We will be using a queue to perform a level order traversal of the tree.
//  We will keep track of the size of the queue at each level to know how many nodes are at that level.
//  We will add the values of the nodes at each level to a list and add that list to the result list.
// We will continue this process until the queue is empty, which means we have traversed all the levels of the tree.
import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *
 *     TreeNode() {}
 *
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public List<List<Integer>> levelOrder(CourseScheduleBFS root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<CourseScheduleBFS> que = new LinkedList<>();

        que.offer(root);

        while (!que.isEmpty()) {

            int size = que.size();

            List<Integer> li = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                CourseScheduleBFS node = que.poll();

                if (node.left != null) {
                    que.offer(node.left);
                }

                if (node.right != null) {
                    que.offer(node.right);
                }

                li.add(node.val);
            }

            result.add(li);
        }

        return result;
    }
}