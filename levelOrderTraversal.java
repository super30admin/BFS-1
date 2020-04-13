// Time Complexity :O(n)
// Space Complexity :O(n+b) where b is breadth at each level.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root==null) return output;
        Queue<TreeNode> bfsQ = new LinkedList<TreeNode>();
        bfsQ.add(root);
        while(!bfsQ.isEmpty())
        {
            List<Integer>  temp = new ArrayList<>();
            Queue<TreeNode> tempQ = new LinkedList<TreeNode>();
            
            while(!bfsQ.isEmpty())
            {
                 TreeNode node = bfsQ.poll();
                 temp.add(node.val);
                  
                if(node.left!=null)
                {
                    tempQ.add(node.left);
                }
                if(node.right!=null)
                {
                    tempQ.add(node.right);
                } 
                
            }
           if(temp.size()!=0)
            {
                output.add(temp);
            }
            while(!tempQ.isEmpty())
            {
                bfsQ.add(tempQ.poll());
            }
  
            
        }
        return output;
            
        
    }
}