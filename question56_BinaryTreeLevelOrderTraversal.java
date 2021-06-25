package BFS1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class question56_BinaryTreeLevelOrderTraversal {
    /* Created by palak on 6/23/2021 */

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
        Iterative Approch:
            Time Complexity: O(n)
            Space Complexity: O(n)
    */

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i = 0 ; i < size ; i++) {
                TreeNode temp = queue.poll();
                tempList.add(temp.val);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            result.add(tempList);
        }
        return result;
    }

    /*
        Recursive Approch:
            Time Complexity: O(n)
            Space Complexity: O(n)
    */

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if(root == null) return result;

        dfs1(root, 0);
        return result;
    }

    private void dfs1(TreeNode root, int level) {
        //BASE
        if(root == null) return;
        //LOGIC
        if(result.size() == level)
            result.add(new ArrayList<>());

        result.get(level).add(root.val);
        dfs1(root.left, level + 1);
        dfs1(root.right, level + 1);
    }

    public static void main(String[] args) {

    }
}