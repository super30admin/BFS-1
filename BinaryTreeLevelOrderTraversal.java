// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
      
        if(root == null)
        {
          return result;
        }
        //implement a queue and add the root to the queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
          int size= queue.size();
          List<Integer> temp = new ArrayList<>();
          
          for(int i = 0 ; i<size;i++)
          {
        	//get the element at the front of the queue to the TreeNode object
            TreeNode front = queue.poll();
            //add it to the list 
            temp.add(front.val);
            //if has a left child add it to the queue
            if(front.left!=null)
            {
              queue.add(front.left);
            }
            //if has a right child add it to the queue
            if(front.right!=null)
            {
              queue.add(front.right);
            }
          }
          result.add(temp);

        }
      return result;
    }
}