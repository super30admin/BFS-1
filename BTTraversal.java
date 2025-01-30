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
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> res = new ArrayList<>();
       Queue<TreeNode> q = new LinkedList<>();
       q.offer (root);
       while (!q.isEmpty()){
        int len = q.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len;i++){
            TreeNode node = q.poll();
            if (node != null){
                list.add (node.val);
                q.offer (node.left);
                q.offer (node.right);
            }
        }
        if (list.size() > 0){
            res.add (list);
        }
       }
       return res; 
    }
}