// Time Complexity :o(N) 
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> finalresult=new LinkedList<List<Integer>>();
        if(root ==null) return finalresult;
        
        Queue<TreeNode> queue = new  LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> result =new LinkedList<> ();
            int count =queue.size();
            for(int i=0;i<count;i++){
                TreeNode current =queue.poll();
                result.add(current.val);
            
            if(current.left!=null){
                queue.add(current.left);
            }
                 if(current.right!=null){
                       queue.add(current.right);
            }
            }
            finalresult.add(result);
        }
        return finalresult;
    }
}