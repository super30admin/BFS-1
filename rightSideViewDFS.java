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
    List<Integer> result=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return result;
        dfs(root,0);
        return result;
    }
    
    private void dfs(TreeNode root,int depth)
    {
        // Base
        if(root==null) return;
        
        //Logic
        if(depth==result.size()) result.add(root.val);
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);
    }
}

// Time Complexity: O(n), n= no of nodes
// Space Complexity: O(n)