/**
Problem: https://leetcode.com/problems/binary-tree-level-order-traversal/
TC: O(n) where n is the total number of nodes in the tree = 2^(h-1) where h = height of the tree.
SC: O(n) The last level in the tree will have the mximum nodes in the queue at a time if all nodes in the last level exist.
Number of nodes in the last level = n/2.
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
class Solution {
    // BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null) {
            return levelOrderTraversal;
        }
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nodes = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                nodes.add(node.val);
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            levelOrderTraversal.add(nodes);
        }

        return levelOrderTraversal;
    }

    // DFS
    List<List<Integer>> res = null;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        levelOrder(root, 0);
        return res;
    }
    
    private void levelOrder(TreeNode root, int height) {
        if (root == null) return;
        
        if (height == res.size()) {
            res.add(new ArrayList<>());
        }
        
        res.get(height).add(root.val);
        levelOrder(root.left, height + 1);
        levelOrder(root.right, height + 1);
    }
}