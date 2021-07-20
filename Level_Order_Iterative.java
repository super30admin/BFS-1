// Time Complexity : O(n), n=number of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
   public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       if(root==null)
           return result;
       //creation of queue
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       while(!queue.isEmpty()) {
           //calculation of size
           int size = queue.size();
           result.add(new ArrayList<>());
           
           //iterate through level
           for(int i=0; i<size; i++) {
               //poll from queue
               TreeNode curr = queue.poll();
               result.get(result.size()-1).add(curr.val);
               
               //left right children
               if(curr.left != null) queue.add(curr.left);
               if(curr.right != null) queue.add(curr.right);
           }
       }
       return result;
   }
}class Level_Order_Iterative {
    
}
