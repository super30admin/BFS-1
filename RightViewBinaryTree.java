// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english:traverse the input node using level order. For each level add the 
// last node in each level to output and return
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
        LinkedList<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<Integer>();
        if(root==null)
            return res;
        q.add(root);
        int size = 0;
        while(!q.isEmpty()){
            size = q.size();
            res.add(q.getLast().val);
            for(int i=0;i<size;i++){
                TreeNode curr = q.remove();
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return res;
    }
}