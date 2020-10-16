// Time Complexity : O(N)
// Space Complexity : O(M) M - Length of longest level
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Using Breath first search and adding right most value at each level to the output.

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
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        if(root == null) return arr;
        TreeNode curr = null;
        queue.add(root);
        
        while(!queue.isEmpty()){
            int qsize = queue.size();
            
            for(int i = 0; i < qsize; i++){
                curr = queue.poll();
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            arr.add(curr.val);
        }
        return arr;
    }
}
