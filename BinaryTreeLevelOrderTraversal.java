import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// To solve the problem iteratively, we just need to maintain a queue and once we traverse trough all the nodes at a level, we need to take the size of the queue, 
// traverse through only those elements which will simulate the level of the tree

// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Compleixty : O(n)

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            }
            levelOrder.add(level);
        }
        return levelOrder;
    }
}
