// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes

import javax.swing.tree.TreeNode;
import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        //
        if(root == null) return result;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
                level.add(curr.val);
                if(curr.left != null) {
                    que.add(curr.left);
                }
                if(curr.right != null) {
                    que.add(curr.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
