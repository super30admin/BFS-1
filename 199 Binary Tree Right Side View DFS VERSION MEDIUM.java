//199 Binary Tree Right Side View DFS VERSION MEDIUM.java
//Time Complexity: O(n)
//Space Complexity: O(n)
//DFS version

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
    public List<Integer> rightSideView(TreeNode root) {
   
        //traversal order : N R L
        List<Integer> result = new ArrayList<>();
        
        //edge case
        if(root == null)
            return result;
        helper(0, root, result);
        return result;    
    }
    public void helper(int level, TreeNode root, List<Integer> result){
        
        //checks condition if CurrentNode is candidate for right view
        //condition for node to be part of right view
        //if Result size is lesser than current level number than current Node is rightView
        if(level >= result.size()){
            result.add(root.val);
        }
        //Process right Node
        if(root.right != null){
            helper(level + 1, root.right, result);
        }

        //Process left Node
        if(root.left != null){
            helper(level + 1, root.left, result);
        }
    }
    
}