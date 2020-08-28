// Time Complexity :O(N), N is the number of nodes
// Space Complexity : O(W), W is the width of the tree, max nodes at the last level
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// It can be done with using dfs as well as bfs algorithm. Using bfs here, I can maintain a queue for storing nodes
// at each level. Since, at each node, I am traversing first left node and then right node, the rightmost node of the level will be
// the last node for that level. I can keep a size variable for each level and can reduce by one for each node at a particular level,
// once size becomes 1 the node left at that level is right most node. So, I will add the node to my result array.
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        return getRightSideView(root);
    }

    public List<Integer> getRightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode current = queue.remove();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);

                if (size == 1) {
                    result.add(current.val);
                }
                size--;
            }
        }
        return result;
    }

}
