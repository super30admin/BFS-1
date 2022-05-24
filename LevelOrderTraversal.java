//Time Complexity: O(N)
//Space Complexity: O(b)  //breadth of the tree
//leetcode: yes
import java.util.*;

public class LevelOrderTraversal {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    /* Solution 1 Iterative */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {

            if (root == null) {
                return new ArrayList<>();
            }

            List<List<Integer>> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            int treeLevel = 0;
            while (queue.size() > 0) {
                treeLevel = queue.size();
                List<Integer> level = new ArrayList<Integer>();
                int index = 0;
                while (index < treeLevel) {
                    TreeNode node = queue.remove();
                    level.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    index++;
                }
                result.add(level);
            }
            return result;
        }
    }
}
