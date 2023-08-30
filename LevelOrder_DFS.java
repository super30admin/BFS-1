// TC: O(n)
// SC: O(h)
class LevelOrder_DFS {
     List<List<Integer>> result ;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result=  new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int height) {
        if(root == null) return;
        if(height == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(height).add(root.val);
        dfs(root.left, height +1);
        dfs(root.right, height +1);
    }
}