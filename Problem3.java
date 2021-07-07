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
LeetCode Submitted : YES
Space Complexity : O(N)
Time Complexity : O(N)

The idea is to store each level nodes in a queue (starting from right) and then add corresponding sub trees nodes of other nodes at the same level. Also, take the first available node in the list for final output.

**/

class Solution {
    List<Integer> output = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null)
            return output;
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode temp =  queue.poll();
            output.add(temp.val);
            
            int size = queue.size();
            
            if(temp.right != null){
                queue.add(temp.right);    
            }
            
            if(temp.left != null){
                queue.add(temp.left);
            }
            
            int count = 0;
            while(count < size){
                temp = queue.poll();
                if(temp.right != null){
                    queue.add(temp.right);    
                }
            
                if(temp.left != null){
                    queue.add(temp.left);
                }
                
                count = count + 1;
            }
        }
        
        return output;
    }
}
