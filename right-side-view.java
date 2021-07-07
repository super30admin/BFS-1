// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//right first (DFS SOLUTION)
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result=new ArrayList<>();
        if(root==null){
            return result;
        }
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root==null){
            return ;
        }
        if(result.size()==level){
            result.add(root.val);
        }
        dfs(root.right, level+1);
        dfs(root.left, level+1);
        return;
    }
}

//left first (DFS SOLUTION)
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result=new ArrayList<>();
        if(root==null){
            return result;
        }
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root==null){
            return ;
        }
        if(result.size()==level){
            result.add(root.val);
        }
        result.set(level, root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
        return;
    }
}