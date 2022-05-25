//done using dfs
//Time - O(n)
//Space - O(h)
//run in leet code - yes
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
        inorder(root,0);
        return result;
    }
    
    void inorder(TreeNode root, int level){
        if(root == null) return;
        if(level > result.size()-1){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        inorder(root.left, level+1);
        inorder(root.right, level+1);
        
    }
}
