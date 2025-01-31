import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(h)
 * 
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None
 *
 * Approach:
 * - Since it checks the right view, we traverse Root, right and left
 * - For everytime a new level is reached, add the value to list
 */
public class BinaryTreeRightSideView {

    // Definition for a binary tree node.
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

    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    // Recursivily look for root, right and left
    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        // if a new level is reached, add the element to result
        if (level == result.size()) {
            result.add(root.val);
        }

        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2, null, n6);
        TreeNode n3 = new TreeNode(3, n4, n5);
        TreeNode n1 = new TreeNode(1, n2, n3);

        BinaryTreeRightSideView obj = new BinaryTreeRightSideView();
        List<Integer> rightSideView = obj.rightSideView(n1);
        System.out.println(rightSideView);
        assert (rightSideView.equals(List.of(1,3,5)));
    }
}
