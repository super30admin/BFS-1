/*
Time Complexity: O(n)
where n is the number of nodes in the binary tree. 
Each node is processed once.
Space Complexity: O(n)
where n is the number of nodes in the binary tree. 
The queue can hold all nodes at the last level in the worst case.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Intuition: Use a queue to perform a level order traversal of the binary tree.

*/

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList();
        ;
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        currList.add(root.val);
        result.add(currList);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                currList = new ArrayList();
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                    currList.add(curr.left.val);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    currList.add(curr.right.val);
                }
                size--;
            }

            if (!currList.isEmpty())
                result.add(currList);
        }

        return result;
    }
}
