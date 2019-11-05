/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

TC:O(n)
SC:O(n)

34 / 34 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 36.2 MB


Problem: To get the size of number of nodes in each level

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        List<List<Integer>> ml = new ArrayList<List<Integer>>();
       if(root == null){
           return ml;
       }
        q.add(root);
      while(q.size()!=0){      
        List<Integer> currentlist = new ArrayList<Integer>();
        int size = q.size();
        for(int i=0;i<size;i++){
            TreeNode curr = q.remove();
            currentlist.add(curr.val);
            
            if(curr.left!=null){
            q.add(curr.left);
            }
            if(curr.right!= null){
            q.add(curr.right);
            }
            
        }
        ml.add(currentlist);
        
            
     } 
        
     return ml;   
        
    }
}
