import java.util.*;
// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(n/2) where n/2 is the number of leaf nodes
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
class Solution {
    public class TreeNode {
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
        List<List<Integer>> result = new ArrayList();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                list.add(curr.val);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            result.add(list);
        }
        return result;
    }
}