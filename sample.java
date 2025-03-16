/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        result.add(new ArrayList<>(temp));
        temp.remove(temp.size()-1);
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    temp.add(curr.left.val);
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    temp.add(curr.right.val);
                    q.add(curr.right);
                }

            }
            if (temp.size() > 0) {
                result.add(new ArrayList<>(temp));
                temp.clear();
            }

        }

        return result;

    }
}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return result;
        }
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int lvl) {
        if (root == null) {
            return;
        }

        if (lvl == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(lvl).add(root.val);
        dfs(root.left, lvl+1);
        dfs(root.right, lvl+1);
    }
}
