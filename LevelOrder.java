
/**
 * LevelOrder
 */

import java.util.*;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> qu = new LinkedList<>();

        qu.add(root);
        while (!qu.isEmpty()) {
            int size = qu.size();
            ArrayList<Integer> lst = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = qu.poll();
                lst.add(temp.val);
                if (temp.left != null)
                    qu.add(temp.left);
                if (temp.right != null)
                    qu.add(temp.right);
            }
            result.add(lst);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}