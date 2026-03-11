
 /**
    Time Complexity : O(N)
    Explanation:
    Each node in the tree is visited exactly once.

    Space Complexity : O(N)
    Explanation:
    In the worst case, the recursion stack or queue can hold up to N nodes
    (for skewed trees or wide levels).

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially implemented the BFS approach using a queue.
    Later implemented a DFS solution by tracking the level of each node.
    Needed to check if the current level already exists in the result list;
    if not, create a new list for that level before adding the node value.
    */

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

   

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    // BFS approach (optional alternative)
    private List<List<Integer>> bfs(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> li = new ArrayList<>();

        if (root == null) return li;

        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode t = q.poll();
                temp.add(t.val);

                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }

            li.add(temp);
        }

        return li;
    }

    // DFS approach used in solution
    private void dfs(TreeNode root, int level, List<List<Integer>> result) {

        if (root == null) return;

        // Create new level list if needed
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }
}