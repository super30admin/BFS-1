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

    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();

        dfs(root, 0);

        return result;

    }

    private void dfs(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if (level == result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; ++i) {
                TreeNode cur = q.poll();

                level.add(cur.val);

                if(cur.left != null) {
                    q.add(cur.left);
                }

                if(cur.right != null) {
                    q.add(cur.right);
                }

            }
            result.add(level);
        }

        return result;

    }
    
}