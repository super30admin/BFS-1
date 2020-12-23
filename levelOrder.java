// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        //Add the root element as its only one
        q.add(root);
        //iterate through the queue
        while(!q.isEmpty()){
            List<Integer> demo = new ArrayList<>();
            int size = q.size();
            for(int i = 0;i<size; i++){
                //remove the top element and add it to the list
                TreeNode temp = q.poll();
                demo.add(temp.val);
                //if left element present add the left node
                if(temp.left != null){
                    q.add(temp.left);
                }
                //if right element present add the right node
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            result.add(demo);
        }
        return result;
    }
    
}