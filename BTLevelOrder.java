// Time Complexity : O(V+E) = O(n)
// Space Complexity : O(n) where n is max diameter or width of all levels
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// For traversing in each level, usde queue to store the elements at each level and run a loop till the size of the queue at each level.
// Traversal will be done from root to both left and right sub tree and so on.
// till the stack is empty, pop out the elements one by one and add it to the list to return.
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
        List<List<Integer>> output = new ArrayList<>();
        if(root==null){
            return output;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){

                TreeNode temp1 = q.poll();
                temp.add(temp1.val);

                if(temp1.left!=null){
                    q.add(temp1.left);
                }
                if(temp1.right!=null){
                    q.add(temp1.right);
                }
            }
            output.add(temp);
        }
        return output;
    }
}