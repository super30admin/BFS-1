//dfs approach
//faster than bfs cuz we use less space stack pop 
// TC O(N) SC O(H) -> H -> height of tree

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int lvl) {
        //base
        if(root == null) {
            return;
        }
        //logic
        if(lvl == result.size()) { // we add a new list to result only if level equals the result size; we increment level each level: notice level is local variable. so 
            // its state is preserved in each recursive call
            result.add(new ArrayList<>());
        }
        result.get(lvl).add(root.val);
        dfs(root.left, lvl + 1);
        dfs(root.right, lvl + 1);
    }
}