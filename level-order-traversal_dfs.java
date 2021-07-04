// Time Complexity : O(n)
// Space Complexity : O(h) .. O(n) for skewed tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        
        /* DFS */
        
        List<List<Integer>> result=new ArrayList<>();
        dfs(root,0,result);
    
        return result;
    }
    
    private void dfs(TreeNode root, int level, List<List<Integer>> result)
    {
        /* Base Case */
        if(root==null)
            return;
        
        /* Action */
        
        if(level==result.size())
            result.add(new ArrayList<>());
        
        result.get(level).add(root.val);
        /* Recurse */
        
        dfs(root.left,level+1,result);
        dfs(root.right,level+1,result);
    }
}