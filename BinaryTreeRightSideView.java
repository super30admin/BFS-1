/**
 * SC : O(n) TC : O(N)
 * Approach : In order to get the right view of the tree find the last element in each level,
 *            so travel through each level and add last node to the result. 
 */
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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // res.add(root.val);
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode curr = null;
            for(int i = 0; i < size; i++){
                curr = q.poll();
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            res.add(curr.val);
        }
        return res;
    }
}