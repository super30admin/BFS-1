
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Time Complexity: Space Complexity: Did this code successfully run on
 * Leetcode: Yes/No Any problem you faced while coding this: None
 *
 * Approach: Explain your approach here.
 */
public class BinaryTreeLevelOrderTraversal {

    //Definition for a binary tree node.
    public static class TreeNode {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }
                list.add(temp.val);
            }
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        // Your code here
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;

        n2.left = new TreeNode(5);
        n2.right = new TreeNode(3);
        n3.right = new TreeNode(9);
        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> levelOrder = obj.levelOrder(n1);
        System.out.println(levelOrder);
        List<List<Integer>> levelOrderExpected = Arrays.asList(Arrays.asList(1), Arrays.asList(3,2), Arrays.asList(5,3,9));
        assert (levelOrderExpected.equals(levelOrder));
    }
}
