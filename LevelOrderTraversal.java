// Time complexity: O(n)
// Space complexity: O(n)
// Approach: Use a queue for fifo and only process the elements that were in the queue initially using size variable

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

class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null)
            return res;
        queue.add(root);
        int size;

        while (!queue.isEmpty()) {
            // only iterate the elements which were in the queue to begin with (aka same
            // level)
            size = queue.size();
            List<Integer> currentLevel = new ArrayList<Integer>();
            while (size != 0) {
                TreeNode current = queue.poll();
                currentLevel.add(current.val);

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
                size--;
            }
            res.add(currentLevel);
        }
        return res;
    }
}