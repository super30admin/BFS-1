package BFS-1;

public class problem1 {
    // Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        
        //DFS SOl
        helper(root,0);
        
        return result;
    }
    
    public void helper(TreeNode root, int lvl){
        if(root == null) return;
        
        if(result.size() == lvl){
            result.add(new ArrayList<>());
        }   
        
        helper(root.left, lvl+1);
        
        helper(root.right, lvl+1);
        result.get(lvl).add(root.val);
    }
}
