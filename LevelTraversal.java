// Time Complexity : O(n), n - nodes
// Space Complexity : O(n), worst case -> no. of leaves which is n/2
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. Use BFS
// 2. Add root to queue and find the size before processing queue, which forms a level
// 3. For each node in queue, add its left and right children if exists

import java.util.*;

class TreeNode {
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

public class LevelTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> nodeQ = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        nodeQ.add(root);

        while(!nodeQ.isEmpty()) {
            int size = nodeQ.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = nodeQ.poll();
                list.add(node.val);

                if(node.left != null) {
                    nodeQ.add(node.left);
                }
                if(node.right != null) {
                    nodeQ.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2),
                new TreeNode(3, new TreeNode(4), null));

        List<List<Integer>> levels = levelOrder(tree);

        for(List<Integer> level : levels) {
            for(int i : level) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}