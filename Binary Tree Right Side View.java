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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
          List<Integer> result = new LinkedList<Integer>();
        if(root == null) return result;
      
         Queue<TreeNode> queue =new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int count=queue.size();
            for(int i=0;i<count;i++){
                TreeNode node= queue.poll();
                if(i== count-1){
                    result.add(node.val);
                }
                if(node.left!=null){
                    queue.add(node.left); 
                }
                  if(node.right!=null){
                    queue.add(node.right); 
                }
                
            }
        }
        return result;
    }
}