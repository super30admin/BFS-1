// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: take list of list and according to the level add node there, if the list for that level if add a list else keep adding the values.

class Solution {
    List<List<Integer>> result;    
    public  List<List<Integer>> levelOrder(TreeNode root) {
        result= new ArrayList<>();
        dfs(root,0);
        return result;
    }
    public void dfs(TreeNode root, int level){
        if(root == null) return ;
        if(result.size()==level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left,level+1);
         dfs(root.right,level+1);

    }
}