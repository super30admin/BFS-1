import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
  List<List<Integer>> out = new LinkedList<>();
  Queue<TreeNode> queue = new LinkedList<>();

  public List<List<Integer>> levelOrder(TreeNode root) {

    if (root == null) return out;

    queue.add(root);

    while (!queue.isEmpty()) {

      List<Integer> li = new LinkedList<>();
      int size = queue.size();

      while (size > 0) {

        TreeNode temp = queue.poll();
        li.add(temp.val);
        if (temp.left != null) {
          queue.add(temp.left);
        }
        if (temp.right != null) {
          queue.add(temp.right);
        }
        size--;
      }
      out.add(li);

    }

    return out;

  }
}
