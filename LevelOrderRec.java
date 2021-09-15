
/**
 * Time complexity is O(n)
 * Space complexity is O(1)
 * 
 * Level order traversal and returning the list of level members
 */

import java.util.*;

public class LevelOrderRec {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root != null)
            helper(root, 0);

        return result;
    }

    public void helper(TreeNode root, int level) {
        if (root == null)
            return;
        if (result.size() - 1 >= level) {
            result.get(level).add(root.val);
        } else {
            ArrayList<Integer> li = new ArrayList<>();
            li.add(root.val);
            result.add(li);
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }

    public static void main(String[] args) {

    }
}
