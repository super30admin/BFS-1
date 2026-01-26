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
    // Solution 1 - Using List of list and having a level variable
    // TC - O(n)
    // SC - O(1)
    // List<List<Integer>> res;

    // public List<List<Integer>> levelOrder(TreeNode root) {
    // this.res = new ArrayList<>();
    // helper(root, 1);
    // return res;
    // }

    // private void helper(TreeNode node, int level) {
    // // Base
    // if (node == null)
    // return;

    // // Logic
    // if (level > res.size()) {
    // List<Integer> li = new ArrayList<>();
    // res.add(li);
    // }
    // res.get(level - 1).add(node.val);

    // // Left
    // helper(node.left, level + 1);

    // // Right
    // helper(node.right, level + 1);
    // }

    // Solution 2 - Using DFS and maintaining the size at the start of each level.
    // TC - O(n)
    // SC - O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                curr.add(node.val);

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }

            res.add(curr);

        }

        return res;
    }
}