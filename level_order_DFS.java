/*
 * Time complexoty=O(n)
 * Space complexity =O(h) where h is height of tree
 * Approach:
 * Solved by DFS 
 * here we make recursive call
 * if lvl is already present in result then get the lvl and add the root value there
 * if not then add the new level and add the root value in the result 
 * if root ==null base case hit return simply
 */
class Solution {
     List<List<Integer>>result;
    public List<List<Integer>> levelOrder(TreeNode root) {
       if(root==null){
        return new ArrayList<>();
       } 
      
      result=new ArrayList<>();
      dfs(root,0);
      return result;
    }
       private void dfs(TreeNode root, int lvl){
           if(root==null){
               return ;
           }
           if(lvl==result.size()){
               List<Integer> temp=new ArrayList<>();
               temp.add(root.val);
               result.add(temp);
           }
           else{
               result.get(lvl).add(root.val);
           }
           dfs(root.left,lvl+1);
           dfs(root.right,lvl+1);
  

       }
}
