/*

Time Complextity: O(n) here n is number of element in the tree. 
Space Complexity: O(n) to get level by level we are using arraylist so space O(n)
 where n is the number of elements stored at each level.

Worked On Leetcode : Yes


*/

import java.util.*;
  
   class TreeNode {
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
 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
     List<List<Integer>> result = new ArrayList<>();
        // base case
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            // size will use for level by level
            int size = queue.size();
            List<Integer> list =  new ArrayList<>();
            
            
            while(size -- > 0)  {
                
                TreeNode curr = queue.poll();
                list.add(curr.val);
            // checking left and right 
                if(curr.left != null)  {
                    
                    queue.add(curr.left);
                }
                
                if(curr.right != null) {
                    
                    queue.add(curr.right);
                }
                
          
                
            }
            result.add((list));
         
        }
        
        
        return result;
    }
}