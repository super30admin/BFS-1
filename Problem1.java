// Time Complexity : O(N)
// Space Complexity : O(M) M - max Level length of the node
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Used Breath first search method to add each level nodes into the list

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
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> output = new ArrayList<>();
        if(root == null) return output;
        
        queue.add(root);
            
        while(!queue.isEmpty()){
            int qsize = queue.size();
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i = 0; i < qsize; i++){
                TreeNode curr = queue.poll();
                arr.add(curr.val);
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            
            output.add(arr);
        }
        return output;
    }
}
