/**
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
 */

//time-O(n)- no of nodes
//space-o(h)- height
//passed in leetcode-yes
class Solution {
    List<List<Integer>> result;
   public List<List<Integer>> levelOrder(TreeNode root) {
       
      result = new ArrayList<List<Integer>>();
       if (root == null) return result;
       dfs(root, 0);
       return result;
   }
   
   public void dfs(TreeNode node, int level)
   {
       //base
       if(node==null) return;

       if (result.size() == level)
       { System.out.println(result.size());
           result.add(new ArrayList<Integer>());
       }
        System.out.println(result.size());
        // fulfil the current level
        result.get(level).add(node.val);        
       
       //recursions
       dfs(node.left, level+1);
       //stk.pop()
       dfs(node.right, level+1);        
   }
}
   
//BFS    
//time- o(n) - n- no of nodes
//space- o(L) - L-leaf nodes- n/2- O(n)
   
   /*
           Queue<TreeNode> q = new LinkedList<TreeNode>();
       List<List<Integer>> result= new ArrayList<List<Integer>>();
        if (root == null) return result;
       q.add(root);
       
       while(!q.isEmpty())
       {
           ArrayList<Integer> list = new ArrayList();
           int size = q.size();
           for(int i=0;i<size;i++)
           {
               TreeNode node=q.remove();
               list.add(node.val);
               if(node.left!=null) q.add(node.left);
               if(node.right!=null) q.add(node.right);
           }
           result.add(list);
           
       }
       
       return result;
   }
   */