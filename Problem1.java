import java.util.List;
import java.util.Queue;

// Time: O(n)
// Space: O(n)
// Used queue to keep each and every level in mind. Then kept each level values in queue

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) {
            return result;
        }

        q.add(root);

        while (!q.isEmpty()) {
            int currentNumber = q.size();
            List<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < currentNumber; i++) {
                TreeNode currentNode = q.poll();

                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }

                currentLevel.add(currentNode.val);
            }
            result.add(currentLevel);

        }

        return result;

    }
}