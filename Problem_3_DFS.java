/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 *  Time Complexity : O(n)
 * 	Space Complexity : O(H) where H is height of Tree
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList<Integer>();
        
        if(root == null){
            return list;
        }
        
        helper(root, list, 0);
        return list;
        
    }
    
    private void helper(TreeNode root, List<Integer> list, int level){
        
        if(root == null){
            return;
        }
        
        if(level == list.size()){
            list.add(root.val);
        }
        
        helper(root.right, list, level+1);
        helper(root.left, list, level+1);
        
        
    }
}