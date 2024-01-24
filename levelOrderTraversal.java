//time O(n)
//space O(n/2)
//approach: use the queue and maintain a size variable to process level by leveland perform BFS

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
        if(root == null) return result;
        bfs(root);
        return result;
    }
    private void bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                    // list.add(curr.left.val);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    // list.add(curr.right.val);
                }
            }
            result.add(list);
        }
    }
}
