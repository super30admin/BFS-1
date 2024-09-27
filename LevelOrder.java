// Time Complexity :O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. Consider a queue that will keep track of elements level order wise.
//2. When you push an element in the queue check if it's left and right childern are null.
//3. If they are not null then you push them into queue and continue the same procedure. 

import java.util.*;

class LevelOrder {
    static class TreeNode {
        int val;
        TreeNode right, left;

        TreeNode(int ele) {
            val = ele;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {

                TreeNode list = q.remove();
                level.add(list.val);

                if (list.left != null)
                    q.add(list.left);
                if (list.right != null)
                    q.add(list.right);

            }
            res.add(level);
        }

        return res;

    }

    public static void main(String args[]) {
        LevelOrder obj = new LevelOrder();
        TreeNode tree = new TreeNode(7);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(15);

        tree.right.left = new TreeNode(9);
        tree.right.right = new TreeNode(20);

       List<List<Integer>> res = obj.levelOrder(tree);
        System.out.println(res);

    }
}