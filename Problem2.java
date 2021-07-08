//Time Complexity : O(n)
//Space Complexity : O(n)

//Code Explaination.
// used the DFS approach as said in the Class. 



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
       List<Integer> result = new ArrayList<>();
        if( root == null) return result;
       int level=0;
       dfs(root,level,result);
       return result;
      
    }
    
    public void dfs(TreeNode root,int level,List<Integer> result){
        
        if(root == null) return;
        
        if(result.size() == level){
             result.add(root.val);
        }
        
        dfs(root.right,level+1,result);
        dfs(root.left,level+1,result);
    }
     
        
}
