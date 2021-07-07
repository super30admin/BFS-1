/*
Author: Akhilesh Borgaonkar
My attempt for DFS for BT
*/

public class DFS {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) { val = data; }
    }

    static void printInorder(TreeNode node) {
        if(node == null)
            return;

        printInorder(node.left);
        System.out.println(node.val);
        printInorder(node.right);
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.left.left = new TreeNode(12);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        printInorder(treeNode);
    }
}
