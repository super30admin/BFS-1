// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root,0);
        return result;
    }
    void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}