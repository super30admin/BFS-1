/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//TC:O(N)
//SC:O(H)--maxdepth
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        //if(root==null) return new ArrayList<List<Integer>>();
        
        int level=0;
        
        dfs(root,level);
        
        
       return list; 
    }
    
    
    public void dfs(TreeNode node,int level )
    {
        if(node==null) return;
        
        if(level==list.size())
        {
          List<Integer> l = new ArrayList<>();
          l.add(node.val); 
          list.add(l);
        }   
        else
        {
           list.get(level).add(node.val);   
        }
        
        if(node.left!=null) dfs(node.left,level+1);
        if(node.right!=null) dfs(node.right,level+1);
  
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}