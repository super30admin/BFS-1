// tc = O(n)
//sc = O(n)

import java.util.LinkedList;
import java.util.Queue;

public class SymmitricTree {
    public static void main(String[] args) {
        SymmitricTree obj = new SymmitricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean obj1 = obj.symmitricMatrix(root);
        System.out.println(" values are = " + obj1);

    }

    public boolean symmitricMatrix(TreeNode root) {

        // null
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && right == null)
                continue;
            if (left == null && right == null)
                return false;
            if (left.val != right.val)
                return false;

            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);

        }
        return true;
    }

}
