/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(N)

The idea is to recursively traverse right side of the tree and check if the depth of the tree == size of the output list - 1. if depth matches size of the output list - 1 add the node to the output list.
**/

class Solution {
    List<Integer> output = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null)
            return output;
        
        rightSide(root,-1);
        return output;
    }
    
    private void rightSide(TreeNode root, int depth){
        //Base Class
        if(root == null)
            return;
        
        //Logic
        if(depth == output.size() - 1)
            output.add(root.val);
        
        rightSide(root.right,depth + 1);
        rightSide(root.left,depth + 1);
        
    }
}
