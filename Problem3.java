/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// Recursive solution (no optimization)
// Time complexity: O(n+m), n = number of nodes. m = no of edges
// Space complexity: O(n)

class Solution {
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        // edge case       
        if(root == null){
            return result;
        }
        traverse(root, 0);
        
        return result;
    }
    
    // traversal technique should be root-> right-> left
    public void traverse(TreeNode node, int depth){
        
        
        // base cases
        if(node == null){
            return;
        }
        if(depth == result.size()){
            result.add(node.val);
        }
                
        // recursive cases
        if(node.right != null){
            traverse(node.right, depth+1);
        }
        
        if(node.left != null);
        {
            traverse(node.left, depth+1);
        }
        
        return;
    }
}


