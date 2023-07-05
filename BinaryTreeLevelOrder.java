import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
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
}

class BinaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        TreeNode cur;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subAns = new LinkedList<Integer>();
            for (int i = 0; i < size; ++i) { // traverse nodes in the same level
                cur = q.poll();
                subAns.add(cur.val); // visit the root
                if (cur.left != null) {
                    q.offer(cur.left); // push left child to queue if it is not null
                }
                if (cur.right != null) {
                    q.offer(cur.right); // push right child to queue if it is not null
                }
            }
            ans.add(subAns);
        }
        return ans;
    }

    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrder binaryTreeLevelOrder = new BinaryTreeLevelOrder();
        List<List<Integer>> levelOrderTraversal = binaryTreeLevelOrder.levelOrder(root);

        // Print the level order traversal
        for (List<Integer> level : levelOrderTraversal) {
            System.out.println(level);
        }
    }
}