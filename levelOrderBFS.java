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

// Time Complexity: Traverse all the node once => O(n)
// Space Complexity: At a single point only that row size elements reside in Queue => O(n/2)
// Did you complete it on leet code: Yes
// Any problems faced: No

// Write your approach here
// Idea here is to use a queue to perform first in and first out
// and use size variable of current queue size
// to be definitive factor of size of list to be added to result
// So, while thesize of queue is not empty we keep iterating till the size of queue
// and take the element out add its value to list and add its left and right
// child to the queue to process later
// on completion of each row, list is added to result.
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                li.add(curr.val);
                if(curr.left!=null) {
                    q.offer(curr.left);
                }
                if(curr.right!=null) {
                    q.offer(curr.right);
                }
            }
            result.add(li);
        }
        return result;
    }
}