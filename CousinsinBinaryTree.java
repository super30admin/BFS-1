public class CousinsinBinaryTree {

    public static void main(String[] args) {
        
        CousinsinBinaryTree obj = new CousinsinBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        root.right.left.right = new TreeNode(20);

        boolean obj1 = obj.cousinsTree(root, 4 , 6);
        System.out.println(obj1);

    }

    TreeNode x_parent;
    TreeNode y_parent;
    int x_depth;
    int y_depth;

    public boolean cousinsTree(TreeNode root, int x, int y) {
        //null case
         if(root == null) return false;
        dfs(root, x, y, 0 , null);
        return x_depth == y_depth && x_parent != y_parent;
   }

    public void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        // base
        if (root == null)
            return;
        // logic

        if (root.val == x) {
            x_parent = parent;
            x_depth = depth;
        }
        if (root.val == y) {
            y_parent = parent;
            y_depth = depth;
        }

        dfs(root.left, x, y, depth + 1, root);
        dfs(root.right, x, y, depth + 1, root);
    }
}

class TreeNode {
    public static TreeNode root;
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

}