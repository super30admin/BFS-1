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

//tc: o(n)
//sc: o(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
   //initiate new list array
       List<List<Integer>>  list = new ArrayList<>();
             if(root == null) return list;
        
        // create a q to poll the value
        Queue<TreeNode> q = new LinkedList<>();
        
        //add root to queue
        q.add(root);
        
        // iterate till q is empty
        while(!q.isEmpty()){
            int size = q.size();
            
            // locat temp array to save the level 
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                // remove the cureent poll 
                TreeNode curr = q.poll();  
                temp.add(curr.val);// add current value to the temp

                // add the babies to the queue
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            // add list after each while iteration
            // this saves order of the tree one by one
            list.add(temp);
        }
        return list;
        //return list
    }
}
