    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/binary-tree-right-side-view/
    Time Complexity for operators : o(n) .. number of  nodes in the TREE
    Extra Space Complexity for operators : o(n) ... used queue to store node 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach same like basic approach: Recursion or Iterative.
                              

            Iterative approach   
                    A. Add first element into the queue as root.
                    B. Traverse thru the queue until it becomes empty.
                    C. In while loop, check the size of queue first that gives the size of level.
                    D. Traverse thru the for loop and add only last the elements to the final list.
                    E. check if that node has left or right nodes if it has then add that into the queue.
                    F. Return final output.

       */


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

   class rightsideView {

    public List<Integer> rightSideView(TreeNode root) {
        
        if(root==null)
            return new ArrayList<>();
        
        List<Integer> output = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i=0;i<size;i++){
                TreeNode tr = queue.poll();
                if(i==size-1)
                    output.add(tr.val);
                
                if(tr.left!=null) queue.add(tr.left);
                if(tr.right!=null) queue.add(tr.right);
            }
        }
        
        return output;
    }
}