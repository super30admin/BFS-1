/*
Author: Akhilesh Borgaonkar
Leetcode: https://leetcode.com/problems/binary-tree-right-side-view/
*/

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) { val = data; }
    }

    static void getRightView(TreeNode root, List<Integer> result, Integer depth) {
        if(root == null)
            return;
        if(depth == result.size())
            result.add(root.val);

        getRightView(root.right, result, depth+1);
        getRightView(root.left, result, depth+1);
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(4);

        List<Integer> result = new ArrayList<>();
        getRightView(treeNode, result, 0);

        System.out.println(result);
    }
}
