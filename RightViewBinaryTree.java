// Time Complexity :O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. Traverse the nodes level order wise and return the right most elements in the tree
//2. We can onsider a stack and check for the elements by pushing level orderly.

import java.util.*;

public class RightViewBinaryTree {
    static class TreeNode {
        int val;
        TreeNode right, left;

        TreeNode(int ele) {
            val = ele;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {

            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {

                TreeNode list = q.remove();

                if (i == qSize - 1)
                    res.add(list.val);

                if (list.left != null)
                    q.add(list.left);
                if (list.right != null)
                    q.add(list.right);

            }
        }

        return res;
    }

    public static void main(String args[]) {
        RightViewBinaryTree obj = new RightViewBinaryTree();

        TreeNode tree = new TreeNode(7);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(15);

        tree.right.left = new TreeNode(9);
        tree.right.right = new TreeNode(20);

        tree.right.left.right = new TreeNode(5);
        tree.right.right.right = new TreeNode(59);
        System.out.println(obj.rightSideView(tree));

    }
}