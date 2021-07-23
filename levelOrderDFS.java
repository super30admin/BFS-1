import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<List<Integer>>();
        
        if(root == null)
            return result;
        
        //to begin the dfs, we send in the root and the level is 0
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        //base
        if(root == null)
            return;
        
        //logic
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        
        //move forward in both directions and level increases by 1
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
        
    }
}