
// Time Complexity :O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
    this.result = new ArrayList<>();
    helper(root, 0);
    return result;
    }
    
    private void helper(TreeNode root, int level){
        //base
        if(root == null) return;
        
        //logic
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        helper(root.left, level+1);
        helper(root.right,level+1);
        
    }
}
