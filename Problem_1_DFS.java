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
 * 	Space Complexity : O(H) where H is height of tree
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        int level = 0;
        helper(root, level, result);
        return result;
    }
    
    public void helper(TreeNode root, int level, List<List<Integer>> result){
        
        if(root == null){
            return;
        }
        
        if(level == result.size()){
            List<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            result.add(list);
        }else{
            List<Integer> list = result.get(level);
            list.add(root.val);
        }
        
        helper(root.left, level+1, result);
        helper(root.right, level+1, result);
    }
}