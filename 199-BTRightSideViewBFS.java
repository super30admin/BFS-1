/**LC-199
 * Time Complexity : O(N) 
 * Space Complexity : O(N/2) = O(N) (Queue space)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm:
 1. If root == null return result
 2. Created a recursive function dfs which will go till any of the node located at the most depth
 3. At any given node, check the level and the resultant array
 4. if level == result.size, create a new list and add it to the result
 5. Now in that list, insert the elements according to their level
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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        //edge
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>(); 
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int last = -1;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                last = curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(last);
            
            
        }
        return result;
    }
}