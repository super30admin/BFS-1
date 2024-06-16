// Time Complexity : O(n) => As we iterate over the n nodes
// Space Complexity : O(n) => As we are storing the nodes in the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach 1: Using BFS(Level Order Traversal). Take queue and add the root
 * node. Run a while loop to check if queue is not empty and use size variable
 * to hold size of the queue. Then usinh for loop start iterating and store the
 * elememts in the resultant list. Then add valid left and right nodes to the
 * queue.
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                temp.add(curr.val);

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            result.add(temp);
        }

        return result;
    }
}