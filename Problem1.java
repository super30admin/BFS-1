
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
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
        
        List<List<Integer>> levels = new ArrayList<>();
     
        if(root==null){
            return levels;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size;i++){
                TreeNode temp=queue.poll();
                level.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            levels.add(level);
          
            }
        
        return levels;
    }
}