/**
 * Definition for a binary tree node.
 */ 


// Time Complexity : O(N)
// Space Complexity : O(H) h: height of tree 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nope


// Your code here along with comments explaining your approach
/*Approach
1) Use a BFS
2) queue

*/

import java.util.*;
 
class Solution {


    public class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
           this.left = left;
             this.right = right;
         }
     }
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root==null)
            return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> templst = new ArrayList();
            for(int i=0;i<size;i++)
            {
                TreeNode n= queue.poll();
                
                templst.add(n.val);
                
                if(n.left!=null)
                {
                    queue.add(n.left);
                }
                if(n.right!=null)
                {
                    queue.add(n.right);
                }
            }
            
            res.add(templst);
        }
        
        return res;
    }
}