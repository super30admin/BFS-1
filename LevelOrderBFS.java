import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// TC - O(N)
// SC - O(N) => Size of queue at last level = N/2

// Constraints:
// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000

public class LevelOrderBFS {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int levelSize = 1;

            while (!queue.isEmpty()) {
                List<Integer> levelList = new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currNode = queue.poll();
                    levelList.add(currNode.val);
                    if (currNode.left != null) {
                        queue.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        queue.add(currNode.right);
                    }
                }
                levelSize = queue.size();
                result.add(levelList);
            }

            return result;
        }
    }
}