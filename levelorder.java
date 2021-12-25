/*
Time Complexity : O(n)
Space Complexity : O(n)
 Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no

 Approach using DFS

 first check if the size of rsult and level are same then add new list and append itto new list;
*/
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
    private void dfs(TreeNode root , int level){
        
        //base
        if(root == null) return;
        
        //logic
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}
