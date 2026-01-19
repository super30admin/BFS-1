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

// Approach 1: BFS traversal using a Queue

// Time: O(N); N = number of nodes in a tree
// Space: O(N) for queue
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queueOfNodes = new LinkedList<>();
        queueOfNodes.offer(root);
        while (!queueOfNodes.isEmpty()) {
            int size = queueOfNodes.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                TreeNode currentNode = queueOfNodes.poll();
                level.add(currentNode.val);
                if (currentNode.left != null) {
                    queueOfNodes.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queueOfNodes.offer(currentNode.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}

// Approach 2: DFS (Recursion)
// Time: O(N); N = number of nodes
// Space: O(h) for the recursive stack (auxiliary space). h = height of tree.
class Solution {
    List<List<Integer>> levelsList = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levelsList;
        }
        dfs(root, 0);
        return levelsList;
    }

    private void dfs(TreeNode node, int level) {
        // Check the level and add a list in levels if not present
        if (levelsList.size() == level) {
            levelsList.add(new ArrayList<>());
        }

        // Add the node to its level
        levelsList.get(level).add(node.val);

        // Process the child nodes
        if (node.left != null) {
            dfs(node.left, level + 1);
        }
        if (node.right != null) {
            dfs(node.right, level + 1);
        }
    }
}