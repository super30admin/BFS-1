//https://leetcode.com/problems/binary-tree-level-order-traversal/

class Solution {
    // Time complexity : O(N)
    // Space complexity : O(h)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        if (root == null)
            return res;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            res.add(level);
        }

        return res;
    }

    // Time complexity : O(N)
    // Space complexity : O(1) Ignoring recursion stack
    public List<List<Integer>> levelOrderR(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    public void helper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null)
            return;

        while (res.size() < level + 1)
            res.add(new ArrayList<>());

        res.get(level).add(root.val);
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);

    }
}