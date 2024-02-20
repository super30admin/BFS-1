import java.util.ArrayList;
import java.util.List;

// TC - O(N)
// SC - O(h) => Recursion Stack - No auxulliary space

// Constraints:
// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000

public class LevelOrderDFSList {

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
        private List<List<Integer>> result;

        public List<List<Integer>> levelOrder(TreeNode root) {
            this.result = new ArrayList<>();

            DFS(root, 0);

            return result;
        }

        private void DFS(TreeNode root, int level) {
            if (root == null) {
                return;
            }

            if (result.size() <= level) {
                List<Integer> currLevelList = new ArrayList<>();
                result.add(currLevelList);
            }
            List<Integer> currLevelList = result.get(level);
            currLevelList.add(root.val);

            DFS(root.left, level + 1);
            DFS(root.right, level + 1);
        }
    }
}