/**
BFS Solution
        
        Time Complexity: O(N)
        Space Complexity: O(1) constant.
        
        List<List<Integer>> result = new ArrayList<>();
        
        //edge case
        if(root == null)return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i< size; i++)
            {
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null)q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(temp);
        }
        return result;
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

// DFS Solution
class Solution {
    
    List<List<Integer>> result; //note result should be in global scope for dfs;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        result = new ArrayList<>();
        
        if(root == null) 
            return result;
        
        dfs(root, 0);
        
        return result;
         
    }
    
    private void dfs(TreeNode root, int level)
    {
        //base (where recursion fails)
        if(root == null)
            return;        
        
        //logic
        if(level == result.size())
            result.add(new ArrayList<>());
        result.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}