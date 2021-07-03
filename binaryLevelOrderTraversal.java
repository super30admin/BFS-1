// Time Complexity :O(n) n - number of tree nodes
// Space Complexity :O(2^h) h - height of the tree
// Did this code successfully run on Leetcode :yes 
class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> list=new ArrayList<>();
       if(root==null) return list;
       Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.poll();
                level.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
                
            }
            list.add(level);
            
        }
        return list;
      
    }
}
/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }

class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> levelOrder(TreeNode root) {
        list=new ArrayList<>();
     
        int level=0;
        helper(root,level);
        return list;
        
    }
    private void helper(TreeNode root,int level)
    {
        if(root==null) return;
        
        if(level>list.size()-1)
            list.add(new ArrayList<>());
   
        list.get(level).add(root.val);
            
        
        helper(root.left,level+1);
        helper(root.right,level+1);
      
	}
}
*/