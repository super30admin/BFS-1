/**LC-234
 * Time Complexity : O(N) 
 * Space Complexity : O(N/2)= O(N) 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : Yes
 * 
 * After knowing the algorithm, I was not able to code. Forgot to check the edge case
 *
 Algorithm:
 1. If root == null return result
 2. Add non null tree nodes and maintain a size variable which will signify the number of nodes at a particular level
 3. we use size variable in order to keep track of which level it is and create a new arrayList temp for each level.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        
        
        q.add(root);
        
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(temp);
        }
        
        return result;
        
    }
}