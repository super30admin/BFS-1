// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        dfs(root, 0);
        return result;
        
    }
    
    private void dfs(TreeNode root, int depth){
        //base
        if(root == null){
            return;
        }
        
        //logic
        if(depth == result.size()){
            result.add(new ArrayList<Integer>());
        }
        result.get(depth).add(root.val);
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}