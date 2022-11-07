
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

public class BTT {
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

            List<List<Integer>> result = new ArrayList<>();

            if (root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {

                Queue<TreeNode> iqueue = new LinkedList<>();
                List<Integer> list = new ArrayList<>();

                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    list.add(node.val);

                    if (node.left != null)
                        iqueue.add(node.left);

                    if (node.right != null)
                        iqueue.add(node.right);
                }
                queue = iqueue;
                result.add(list);

            }

            return result;
        }
    }

