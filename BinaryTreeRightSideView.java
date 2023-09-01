// Tc = O(n)
//Sc = O(1)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//import javax.swing.tree.TreeNode;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {

        // int[][] arr = {{1},{2},{3},null,{5},null,{4}};

        BinaryTreeRightSideView obj = new BinaryTreeRightSideView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(7);

        List<Integer> obj1 = obj.rightView(root);
        System.out.println(obj1);

    }

    public List<Integer> rightView(TreeNode root) {

        // null
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == size - 1) {
                    result.add(curr.val);

                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);

            }

        }
        return result;

    }
}

// define a TreeNode class

class TreeNode {
    public static TreeNode root;
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

}