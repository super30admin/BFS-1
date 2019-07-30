/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root==null) return result;
        else{
            List<TreeNode> q = new ArrayList();
            q.add(root);
            while(!q.isEmpty()){
                int x = q.size();
                List<Integer> sub = new ArrayList();
                for(int i=0;i<x;i++){
                    TreeNode next = q.remove(0);
                    if(next.left!=null) q.add(next.left);
                    if(next.right!=null) q.add(next.right);
                    sub.add(next.val);
                }
                result.add((sub));
                
            }
            return result;
        }
    }
}
