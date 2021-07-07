/*
Author: Akhilesh Borgaonkar
Leetcode: https://leetcode.com/problems/binary-tree-level-order-traversal/
*/

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int level = 0;
        computeBFS(root, result, level);

        return result;
    }

    private static void computeBFS(TreeNode root, List<List<Integer>> result, int level) {
        if(root == null)
            return;
        if(level == result.size())
            result.add(new ArrayList<>());

        result.get(level).add(root.val);
        computeBFS(root.left, result, level+1);
        computeBFS(root.right, result, level+1);
    }

    public static void main(String[] args) {
        TreeNode inputTree = new TreeNode(3);
        inputTree.left = new TreeNode(9);
        inputTree.right = new TreeNode(20);
        inputTree.right.left = new TreeNode(15);
        inputTree.right.right = new TreeNode(7);

        List<List<Integer>> output = levelOrder(inputTree);
        System.out.println(output);

    }
}
