
// Time Complexity : O(n)
//Space Complexity : O(H) the width of the tree 
//Did this code successfully run on Leetcode : Yes

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
    
      result   = new ArrayList<>();
        if(root == null) return new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        //base
        if(root == null) return;
        //logic
        
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}