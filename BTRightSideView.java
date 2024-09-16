// Time Complexity : O(n) 
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// Recursive

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root ==null)
            return res;
        
        dfs(root, 0);
        return res;
    }
    
    private void dfs(TreeNode root, int level){       
        if(level==res.size()){
            res.add(root.val);
        }
        
        if(root.right != null){
            dfs(root.right, level +1);
        }
        if(root.left != null){
            dfs(root.left, level +1);
        }
    }
}