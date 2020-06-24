// Time Complexity: O(n) : n -> number of nodes in tree
// Space Complexity: O(h): size of recursive stack

class Solution{
    TreeNode x_parent, y_parent;
    int x_depth, y_depth;
    public boolean isCousins(TreeNode root, int x, int y){

        if(root == null) return false;

        dfs(root, 0, null, x, y);

        return x_parent != y_parent && x_depth == y_depth;


    }

    private void dfs(TreeNode root, int depth, TreeNode parent, int x, int y){

        // base case
        if(root == null) return;

        //logic
        if(root.val == x){
            x_depth = depth;
            x_parent = parent;
        }

        if(root.val == y){
            y_depth = depth;
            y_parent = parent;
        }

        dfs(root.left, depth + 1, root, x, y);
        dfs(root.right, depth + 1, root, x, y);


    }
}
