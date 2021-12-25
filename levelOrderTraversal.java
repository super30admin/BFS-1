// Time Complexity : O(n)
// Space Complexity : O(n), for the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// BFS solution: We use a queue to store the TreeNodes
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();
                li.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            result.add(li);
        }
        return result;
    }
}