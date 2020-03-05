
// Time: O(n)
// Space: O(n)
// Used queue to keep each and every level in mind. Then kept each level values in queue. Added the last element at each level in the result

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
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

                if (i == currentNumber - 1) {
                    result.add(currentNode.val);
                }
            }

        }

        return result;

    }
}