// Time Complexity : O(n)
// Space Complexity : O(n)
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
        // create a list of lists to store all the levelwise list
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        // BFS (visiting all the child nodes of a parent)
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            // System.out.println("Current queue size: " + size);
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();      // removing element from the queue
                temp.add(curr.val);            // adding that element to the temporary levelwise list 
                // System.out.println("Elements present in queue: " + curr.val);
                // System.out.println("Temporary levelwise list: " + temp);
                
                // check whether children of the current element are present
                // if they are present, add them to the queue 
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            // add the temporary levelwise list to the resultant list
            result.add(temp);
            // System.out.println("Resultant list after each level: "+ result);
        }
        return result;
    }
}