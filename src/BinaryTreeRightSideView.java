// Time Complexity : o(n)
// Space Complexity : o(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * dfs on right side, if result do not have number for current level, add it
 * 
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 
 */
public class BinaryTreeRightSideView {
	List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
       res = new ArrayList<>();
       dfs(root, 0); 
       return res;
    }
    
    private void dfs(TreeNode root, int level) {
        if(root == null) return;
        
        //if number for current level is not in the result, 
        // root.val is visible from the right, add it to the result
        if(res.size() == level) {
            res.add(root.val);
        }
        
        //since we are doing right side image, call recursion on right first
        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}
