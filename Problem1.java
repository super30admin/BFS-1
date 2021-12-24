//time o(n)
//space o(n)

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
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 1);
        return res;
    }
    
    private void helper(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        
        if(res.size() < level) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            res.add(temp);
        } else {
            res.get(level-1).add(root.val);
        }
        
        
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
    
    
}
