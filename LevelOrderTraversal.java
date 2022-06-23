public class LevelOrderTraversal {
    // TC is O(n)
    // SC of recursive stack is O(h)
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return result;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        // base
        if (root == null)
            return;

        // logic
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        dfs(root.left, level + 1);

        // right

        dfs(root.right, level + 1);
        result.get(level).add(root.val);
    }
}
