public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode getNode(int data) {
        return new TreeNode(data);
    }

    // [3,9,20,null,null,15,7]
    public TreeNode getSample() {
        TreeNode root = getNode(3);
        TreeNode node9 = getNode(9);
        TreeNode node20 = getNode(20);
        TreeNode node15 = getNode(15);
        TreeNode node7 = getNode(7);

        root.left = node9;
        root.right = node20;

        node20.left = node15;
        node20.right = node7;
        return root;
    }

}
