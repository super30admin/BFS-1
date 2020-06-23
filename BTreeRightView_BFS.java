// Time Complexity : O(n) --> where n is number of nodes in the tree  
// Space Complexity : O(n) {exact: O(n/2)}
// Did this code successfully run on Leetcode (199): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    // BFS Approach
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int last = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                last = curr.val;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            result.add(last);
        }
        return result;
    }
}