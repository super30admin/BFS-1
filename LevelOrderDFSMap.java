import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TC - O(N)
// SC - O(N) => HashMap with all elements

// Constraints:
// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000

public class LevelOrderDFSMap {

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
        private Map<Integer, List<Integer>> map;

        public List<List<Integer>> levelOrder(TreeNode root) {
            this.result = new ArrayList<>();
            this.map = new HashMap<>();

            DFS(root, 0);

            // Adding lists to the result from map
            // Map has level as keys
            // Number of levels = Map.size()
            for (int i = 0; i < map.size(); i++) {
                result.add(map.get(i));
            }

            return result;
        }

        private void DFS(TreeNode root, int level) {
            if (root == null) {
                return;
            }

            if (map.size() <= level) {
                List<Integer> currLevelList = new ArrayList<>();
                map.put(level, currLevelList);
            }
            List<Integer> currLevelList = map.get(level);
            currLevelList.add(root.val);

            DFS(root.left, level + 1);
            DFS(root.right, level + 1);
        }
    }
}