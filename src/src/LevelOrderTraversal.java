import java.util.ArrayList;
import java.util.List;

/*
TC : O(n) where n is the number of nodes in the tree
SC : O(n) where n is the number of nodes in the tree
Leetcode : yes
Problems faced :no
 */

/**
 * The approach used is a recursive one. At each step, we pass the current level and
 * compare it with the len of the output list.
 * If The length of output list is equal to the the current level, that means new list should be made
 * else the current node can be added at the end of the last internal list.
 */
public class LevelOrderTraversal {

    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder_recursive_approach(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }


    /*
TC : O(n) where n is the number of nodes in the tree
SC : O(n) where n is the number of nodes in the tree
Leetcode : yes
Problems faced :no
 */


    /**
     * The approach is same as the recursive one, just that we have used queue to perform iterative approach.
     * Here we use the size of the queue to identify that the nodes belong to the same level
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_iterative_approach(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            // start the current level
            levels.add(new ArrayList<Integer>());

            // number of elements in the current level
            int level_length = queue.size();
            for (int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();

                // fulfill the current level
                levels.get(level).add(node.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // go to next level
            level++;
        }
        return levels;
    }
}
